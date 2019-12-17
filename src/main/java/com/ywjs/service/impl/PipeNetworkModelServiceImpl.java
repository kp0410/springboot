/** 
 * @file: PipeNetworkModelService.java 
 * @Package： com.ywjs.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月11日 下午5:40:45 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */
package com.ywjs.service.impl;

import com.ywjs.common.constant.CodeMsg;
import com.ywjs.common.utils.GetRealTimeDataUtil;
import com.ywjs.common.utils.RealTimeDataUtil;
import com.ywjs.exception.GlobalException;
import com.ywjs.mapper.*;
import com.ywjs.model.dto.GetRealTimeDataDTO;
import com.ywjs.model.dto.SaveProjectDTO;
import com.ywjs.model.entity.*;
import com.ywjs.model.vo.*;
import com.ywjs.service.HttpClientService;
import com.ywjs.service.PipeNetworkModelService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

/**
 * @ClassName PipeNetworkModelService
 * @Description TODO(管网物理模型管理Service)
 * @Author 周伟
 * @Date 2019年11月11日 下午5:40:45
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Service("pipeNetworkModelService")
@Transactional(rollbackFor = Exception.class)
public class PipeNetworkModelServiceImpl implements PipeNetworkModelService {

    private static Logger log = Logger.getLogger(PipeNetworkModelServiceImpl.class);
    @Autowired
    HttpClientService client;
    /** 工程dao */
    @Autowired
    ProjectMapper projectMapper;
    /** 工程备份dao */
    @Autowired
    ProjectAffiliatedMapper projectAffiliatedMapper;
    /** 属性与元件种类dao */
    @Autowired
    EletypePropertyMapper eletypePropertyMapper;
    /** 属性dao接口 */
    @Autowired
    PropertyMapper propertyMapper;
    /** 原件拓扑信息dao接口 */
    @Autowired
    ElementMapper elementMapper;
    /** 原件节点dao接口 */
    @Autowired
    ElementNodeMapper elementNodeMapper;
    /** 工况dao接口 */
    @Autowired
    WorkingConditionMapper workingConditionMapper;
    /** 属性值dao接口 */
    @Autowired
    PropertyValueMapper propertyValueMapper;
    /** 仿真模拟方案dao接口 */
    @Autowired
    SimulationMapper SimulationMapper;

    /**
     * @Description: TODO(保存工程并返回主键值) @author： 2019年11月12日 周伟 创建初始版本
     * @param project
     *            工程实体对象
     */
    @Override
    public HashMap<String, Long> savaNewProject(Project project) {
        if (StringUtils.isEmpty(project.getProjectnamePro())) {
            return null;
        }

        ProjectExample projectExample = new ProjectExample();
        projectExample.createCriteria().andProjectnameProEqualTo(project.getProjectnamePro());
        List<Project> selectByExample = projectMapper.selectByExample(projectExample);
        if (selectByExample.size() > 0) {
            throw new GlobalException(CodeMsg.PGGWMO_DELBYPROJECTID_ERROR);
        }

        Date date = new Date();
        project.setCreatedatePro(date);
        // 工程表插入
        projectMapper.insertSelective(project);
        // 工程备份表的插入
        ProjectAffiliated projectAffiliated = new ProjectAffiliated();
        projectAffiliated.setProjectidPro(project.getProjectidPro());
        // projectAffiliated.setCreatedateProaff(date);
        projectAffiliatedMapper.insertSelective(projectAffiliated);
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("projectid", project.getProjectidPro());
        hashMap.put("projectaffid", projectAffiliated.getProjectidProaff());
        return hashMap;
    }

    @Override
    public List<Project> getProject() {
        return projectMapper.selectAll();// 降序
    }

    // @Cacheable(value = "map", keyGenerator = "wiselyKeyGenerator")
    @Override
    public HashMap<String, Object> getAttributeList() {
        // 封装数据的容器
        HashMap<String, Object> hashMap = new HashMap<>();
        ArrayList<Object> arrList = new ArrayList<>();
        // 查询所有属性
        List<Property> selectPropertyAll = propertyMapper.selectAll();
        // 封装属性数据
        hashMap.put("DEFAULT_ATTRS", selectPropertyAll);
        // 查询属性与元件种类表所有数据
        List<EletypeProperty> selectEletypePropertyAll = eletypePropertyMapper.selectAll();
        // 解析数据为需要格式（分组归并）
        Map<String, List<EletypeProperty>> map = selectEletypePropertyAll.stream()
                .collect(Collectors.groupingBy(EletypeProperty::getEletypeElepro));
        Iterator<Entry<String, List<EletypeProperty>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<EletypeProperty>> entry = iterator.next();
            HashMap<String, Object> tmpMap = new HashMap<String, Object>();
            tmpMap.put("elementtype", entry.getKey());
            ArrayList<Object> tmpList = new ArrayList<>();
            List<EletypeProperty> list = entry.getValue();
            for (EletypeProperty eletypeProperty : list) {
                tmpList.add(eletypeProperty.getPropertyidPro());
            }
            tmpMap.put("arrtid", tmpList);
            arrList.add(tmpMap);
            // tmpMap.clear();
        }

        hashMap.put("ATTR_CLASSIFY", arrList);
        return hashMap;
    }

    @Override
    public Long saveProject(SaveProjectDTO saveProjectDTO) {
        /** 删除历史Issaveproaff为0的工程，最后保存的数据不管是否为0都不删除 */
        // deleteProjectByProjectId();
        // 1、 查询要删除的工程备份表数据
        ProjectAffiliatedExample affiliatedExample = new ProjectAffiliatedExample();
        affiliatedExample.setOrderByClause("PROJECTID_PROAFF desc");
        affiliatedExample.createCriteria().andProjectidProEqualTo(saveProjectDTO.getProjectid())
                .andIssaveProaffEqualTo(0);
        // 查询标识为0，为该工程id的所有工程备份数据,倒序第一条不删除
        List<ProjectAffiliated> selectByExample = projectAffiliatedMapper.selectByExample(affiliatedExample);

        if (!(CollectionUtils.isEmpty(selectByExample))) {
            // 1.1、 查询maxKey的记录判断Issaveproaff是否为0
            Long projectidProaff = selectByExample.get(0).getProjectidProaff();
            // 从工程备份的删除列表排除
            selectByExample = selectByExample.stream().filter((e) -> e.getProjectidProaff() != projectidProaff)
                    .collect(Collectors.toCollection(ArrayList::new));

            // 3、 查询要删除的信息,逆序删除，先删除属性值信息
            for (ProjectAffiliated projectAffiliated : selectByExample) {
                WorkingConditionExample workingConditionExample = new WorkingConditionExample();
                workingConditionExample.createCriteria()
                        .andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
                List<WorkingCondition> exampleWC = workingConditionMapper.selectByExample(workingConditionExample);
                for (WorkingCondition workingCondition : exampleWC) {
                    // 根据属性值表和工况的关系（外键），删除属性值表数据
                    PropertyValueExample propertyValueExample = new PropertyValueExample();
                    propertyValueExample.createCriteria().andWorkidWorkEqualTo(workingCondition.getWorkidWork());
                    propertyValueMapper.deleteByExample(propertyValueExample);
                }
            }
            // 4、 删除，逆序删除
            for (ProjectAffiliated projectAffiliated : selectByExample) {
                // 4.1 删除元件节点坐标信息
                ElementNodeExample elementNodeExample = new ElementNodeExample();
                elementNodeExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
                elementNodeMapper.deleteByExample(elementNodeExample);
                // 4.2 删除元件拓扑信息
                ElementExample elementExample = new ElementExample();
                elementExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
                elementMapper.deleteByExample(elementExample);
                // 4.3 删除工况信息
                WorkingConditionExample eorkingConditionExample = new WorkingConditionExample();
                workingConditionMapper.deleteByExample(eorkingConditionExample);
            }

            // 5、 删除工程备份
            for (ProjectAffiliated projectAffiliated : selectByExample) {
                projectAffiliatedMapper.deleteByPrimaryKey(projectAffiliated.getProjectidProaff());
            }
        }

        /** 保存工程 */
        // 修改预备备份表信息
        ProjectAffiliated affiliated = new ProjectAffiliated();
        affiliated.setCreatedateProaff(new Date());
        affiliated.setRemarkProaff(saveProjectDTO.getRemark());
        affiliated.setIssaveProaff(saveProjectDTO.getIssaveproaff());
        affiliated.setProjectidPro(saveProjectDTO.getProjectid());
        ProjectAffiliatedExample example = new ProjectAffiliatedExample();
        example.createCriteria().andProjectidProaffEqualTo(saveProjectDTO.getProjectaffid());
        projectAffiliatedMapper.updateByExampleSelective(affiliated, example);

        // 元件节点坐标表信息插入
        List<ElementNode> nodelist = saveProjectDTO.getNodelist();
        if (nodelist.size() > 1000){
            int count = nodelist.size() / 1000;
            int remainder = nodelist.size() % 1000;
            // 记录下标
            int index = 0;
            // 分批插入
            for (int i = 0; i < count; i++) {
                List<ElementNode> subList = nodelist.subList(index, index+1000);
                elementNodeMapper.insertBatch(subList);
                index = index+1000;
            }
            if(remainder > 0){
                List<ElementNode> subList = nodelist.subList(index, index+remainder);
            }
        }else{
            elementNodeMapper.insertBatch(nodelist);
        }


        // 原件拓扑信息表的插入
        List<Element> elementlist = saveProjectDTO.getElementlist();
        if (elementlist.size() > 1000){
            int count = elementlist.size() / 1000;
            int remainder = elementlist.size() % 1000;
            // 记录下标
            int index = 0;
            // 分批插入
            for (int i = 0; i < count; i++) {
                List<Element> elements = elementlist.subList(index, index + 1000);
                elementMapper.insertBatch(elements);
                index = index+1000;
            }
            if(remainder > 0){
                List<Element> elements = elementlist.subList(index, index + remainder);
                elementMapper.insertBatch(elements);
            }
        }else{
            elementMapper.insertBatch(elementlist);
        }

        /** 工况表的插入 */
        // 属性值表数据分组
        Map<Long, List<PropertyValue>> map = saveProjectDTO.getAttrilist().stream()
                .collect(Collectors.groupingBy(PropertyValue::getWorkidWork));

        for (WorkingCondition workingCondition : saveProjectDTO.getArclist()) {
            // 记录前台生成的虚拟ID
            Long virtualId = workingCondition.getWorkidWork();
            // 插入到工况表
            workingCondition.setProjectidProaff(saveProjectDTO.getProjectaffid());
            workingConditionMapper.insertSelective(workingCondition);
            // 修改属性值数据，修改为生成的工况id
            List<PropertyValue> list = map.get(virtualId);
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setWorkidWork(workingCondition.getWorkidWork());
            }
            map.put(virtualId, list);

        }

        // 合并list
        List<PropertyValue> total = new ArrayList<>();
        Iterator<Entry<Long, List<PropertyValue>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Long, List<PropertyValue>> entry = iterator.next();
            total.addAll(entry.getValue());
        }
        // 属性值表的插入，需要工况表拓扑表主键值（自增需要查询）
        //propertyValueMapper.insertBatch(total);
        if (total.size() > 1000){
            int count = total.size() / 1000;
            int remainder = total.size() % 1000;
            // 记录下标
            int index = 0;
            // 分批插入
            for (int i = 0; i < count; i++) {
                List<PropertyValue> propertyValues = total.subList(index, index + 1000);
                propertyValueMapper.insertBatch(propertyValues);
                index = index+1000;
            }
            if(remainder > 0){
                List<PropertyValue> propertyValues = total.subList(index, index + remainder);
                propertyValueMapper.insertBatch(propertyValues);
            }
        }else{
            propertyValueMapper.insertBatch(total);
        }


        // 封装插入数据
        ProjectAffiliated projectAffiliated = new ProjectAffiliated();
        projectAffiliated.setProjectidPro(saveProjectDTO.getProjectid());
        // 插入,将插入数据主键值返回到po中
        projectAffiliatedMapper.insertSelective(projectAffiliated);
        return projectAffiliated.getProjectidProaff();

    }


    @Override
    public List<ProjectAffiliated> getProaffByProjectIdList(Long projectid) {

        ProjectAffiliatedExample example = new ProjectAffiliatedExample();
        example.setOrderByClause("PROJECTID_PROAFF desc");
        example.createCriteria().andProjectidProEqualTo(projectid);
        List<ProjectAffiliated> selectByExample = projectAffiliatedMapper.selectByExample(example);
        return selectByExample;
    }

    @Override
    public Object openProjectByProjectId(Long projectid, Integer idtype) {
        /***
         * idtype: 1: projectid为工程编号,根据projectid取出备份表最后保存的一套数据 2： projectid为工程备份表ID，可根据ID直接获各表的项目数据
         */
        ProjectAffiliated projectAffiliated = null;
        if (idtype == 2) {
            // 传过来的是备份表id，查询工程备份表，获取工程id
            ProjectAffiliated projectAff = projectAffiliatedMapper.selectByPrimaryKey(projectid);
            if (projectAff.getIssaveProaff() != 2) {
                projectAffiliated = projectAff;
            } else {
                ProjectAffiliatedExample example = new ProjectAffiliatedExample();
                example.setOrderByClause("PROJECTID_PROAFF desc");
                example.createCriteria().andProjectidProEqualTo(projectAff.getProjectidPro())
                        .andIssaveProaffNotEqualTo(2);
                List<ProjectAffiliated> selectByExample = projectAffiliatedMapper.selectByExample(example);
                if (selectByExample != null && selectByExample.size() > 0) {
                    projectAffiliated = selectByExample.get(0);
                }
            }
        } else {
            // 传过来的是工程id，查询工程备份表最后保存的一条数据
            ProjectAffiliatedExample example = new ProjectAffiliatedExample();
            example.setOrderByClause("PROJECTID_PROAFF desc");
            example.createCriteria().andIssaveProaffNotEqualTo(2).andProjectidProEqualTo(projectid);
            List<ProjectAffiliated> selectByExample = projectAffiliatedMapper.selectByExample(example);
            if (selectByExample != null && selectByExample.size() != 0) {
               projectAffiliated = selectByExample.get(0);
            }
        }
        Map<String, Object> mapAll = new HashMap<>();
        Project project;
        if (projectAffiliated == null) { // 为保存新建打开的情况
            project = projectMapper.selectByPrimaryKey(projectid);
            // 查询工程表获取工程名
            mapAll.put("id", project.getProjectidPro());
            mapAll.put("name", project.getProjectnamePro());
            mapAll.put("arcList", new ArrayList<>());
            mapAll.put("nodeList", new ArrayList<>());
            mapAll.put("deviceArr", new ArrayList<>());
        } else {
            project = projectMapper.selectByPrimaryKey(projectAffiliated.getProjectidPro());
            mapAll.put("id", project.getProjectidPro());
            mapAll.put("name", project.getProjectnamePro());
            // 查询工况根据projectid
            WorkingConditionExample workingConditionExample = new WorkingConditionExample();
            workingConditionExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
            List<WorkingCondition> workingConditionList = workingConditionMapper
                    .selectByExample(workingConditionExample);
            /** 封装为工况集合 (工况表+属性值表（子表）) */
            if (CollectionUtils.isEmpty(workingConditionList)) {
                mapAll.put("arcList", new ArrayList<>());
            } else {
                // 根据工况id 查询存储属性值表
                List<Object> arcList = new ArrayList<>();
                for (WorkingCondition workingCondition : workingConditionList) {
                    Map<String, Object> arcItemMap = new HashMap<>();
                    // 封装单个工况的容器
                    arcItemMap.put("id", workingCondition.getWorkidWork());
                    arcItemMap.put("name", workingCondition.getWorknameWork());
                    arcItemMap.put("arcDescribe", workingCondition.getRemarkProaff());

                    PropertyValueExample propertyValueExample = new PropertyValueExample();
                    propertyValueExample.createCriteria().andWorkidWorkEqualTo(workingCondition.getWorkidWork());
                    List<PropertyValue> listPropertyValue = propertyValueMapper.selectByExample(propertyValueExample);

                    if (CollectionUtils.isEmpty(listPropertyValue)) {
                        arcItemMap.put("device", new ArrayList<>());
                    } else {
                        // 属性值数据根据工况id分组
                        Map<String, List<PropertyValue>> PVMap = listPropertyValue.stream()
                                .collect(Collectors.groupingBy(PropertyValue::getElementrealnameEle));
                        Iterator<Entry<String, List<PropertyValue>>> iterator = PVMap.entrySet().iterator();
                        List<Object> tmpList1 = new ArrayList<>();
                        List<Object> deviceList = new ArrayList<>();
                        while (iterator.hasNext()) {
                            Entry<String, List<PropertyValue>> entry = iterator.next();

                            Map<String, Object> deviceItemMap = new HashMap<>();
                            deviceItemMap.put("id", entry.getKey());
                            List<PropertyValue> list = entry.getValue();
                            List<Object> attrList = new ArrayList<>();

                            for (PropertyValue propertyValue : list) {
                                Map<String, Object> attrItemMap = new HashMap<>();
                                attrItemMap.put("k", propertyValue.getPropertyidPro());
                                attrItemMap.put("v", propertyValue.getProvalueProval());
                                attrList.add(attrItemMap);
                            }
                            deviceItemMap.put("attr", attrList);
                            deviceList.add(deviceItemMap);
                        }
                        arcItemMap.put("device", deviceList);
                    }
                    // 封装到数据容器
                    arcList.add(arcItemMap);
                }
                // 数据容器封装
                mapAll.put("arcList", arcList);
            }

            /** 查询元件节点表 根据projectid */
            ElementNodeExample elementNodeExample = new ElementNodeExample();
            elementNodeExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
            List<ElementNode> listElementNode = elementNodeMapper.selectByExample(elementNodeExample);
            if (CollectionUtils.isEmpty(listElementNode)) {
                mapAll.put("nodeList", new ArrayList<>());
            } else {
                List<Object> nodeList = new ArrayList<>();
                for (ElementNode elementNode : listElementNode) {
                    Map<String, Object> nodeMap = new HashMap<>();
                    nodeMap.put("id", elementNode.getNodenumNdl());
                    nodeMap.put("layerid", elementNode.getLayeridEle());
                    Map<String, Object> ptMap = new HashMap<>();
                    ptMap.put("x", elementNode.getNodexNdl());
                    ptMap.put("y", elementNode.getNodeyNdl());
                    nodeMap.put("pt", ptMap);
                    nodeList.add(nodeMap);
                }
                // 添加到数据容器
                mapAll.put("nodeList", nodeList);
            }

            /** 查询元件拓扑表根据projectid */
            List<Object> deviceList = new ArrayList<>();
            ElementExample elementExample = new ElementExample();
            elementExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
            List<Element> selectByExample = elementMapper.selectByExample(elementExample);
            if (CollectionUtils.isEmpty(selectByExample)) {
                mapAll.put("deviceArr", new ArrayList<>());
            } else {
                for (Element element : selectByExample) {
                    Map<String, Object> deviceItemMap = new HashMap<>();
                    deviceItemMap.put("id", element.getElementrealnameEle());
                    deviceItemMap.put("type", Integer.parseInt(element.getElementtypeEle()));
                    deviceItemMap.put("p1", element.getNodestarEle());
                    deviceItemMap.put("p2", element.getNodeendEle());
                    deviceItemMap.put("layer", element.getLayeridEle());
                    Map<String, Object> cpMap = new HashMap<>();
                    cpMap.put("x", element.getStarxEle());
                    cpMap.put("y", element.getStaryEle());
                    deviceItemMap.put("cp", cpMap);
                    deviceList.add(deviceItemMap);
                }
                // 添加到数据容器
                mapAll.put("deviceArr", deviceList);
            }

        }
        // 判断是否需要插入预备数据
        ProjectAffiliated PAreverse = projectAffiliatedMapper.selectReverse(projectAffiliated.getProjectidPro());
        if (PAreverse.getIssaveProaff() == 2) {
            mapAll.put("newid", PAreverse.getProjectidProaff());
        } else {
            // 插入预备工程备份数据
            ProjectAffiliated projectAff = new ProjectAffiliated();
            projectAff.setProjectidPro(projectAffiliated.getProjectidPro());
            projectAff.setProusernameProaff("测试用户");
            // projectAff.setCreatedateProaff(new Date());
            // 插入,将插入数据主键值返回到po中
            projectAffiliatedMapper.insertSelective(projectAff);
            mapAll.put("newid", projectAff.getProjectidProaff());
        }
        return mapAll;
    }

    @Override
    public int proaffCountByProjectId(Long projectid) {
        ProjectAffiliatedExample projectAffiliatedExample = new ProjectAffiliatedExample();
        projectAffiliatedExample.createCriteria().andProjectidProEqualTo(projectid);
        return projectAffiliatedMapper.countByExample(projectAffiliatedExample);
    }

    // 根据工程表ID删除备份表及其他相关数据
    @Override
    public void deleteProjectByProjectId(Long projectid) {
        /** 删除历史Issaveproaff为0的工程，最后保存的数据不管是否为0都不删除 */
        // 1、 查询要删除的工程备份表数据
        ProjectAffiliatedExample affiliatedExample = new ProjectAffiliatedExample();
        affiliatedExample.createCriteria().andProjectidProEqualTo(projectid);
        List<ProjectAffiliated> selectByExample = projectAffiliatedMapper.selectByExample(affiliatedExample);

        // 判断是后有关联数据，否则只删除工程表
        if (selectByExample == null || selectByExample.size() <= 0) {
            projectMapper.deleteByPrimaryKey(projectid);
            return;
        }

        // 3、 查询要删除的信息,逆序删除，先删除属性值信息
        for (ProjectAffiliated projectAffiliated : selectByExample) {
            WorkingConditionExample workingConditionExample = new WorkingConditionExample();
            workingConditionExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
            List<WorkingCondition> exampleWC = workingConditionMapper.selectByExample(workingConditionExample);
            for (WorkingCondition workingCondition : exampleWC) {
                // 根据属性值表和工况的关系（外键），删除属性值表数据
                PropertyValueExample propertyValueExample = new PropertyValueExample();
                propertyValueExample.createCriteria().andWorkidWorkEqualTo(workingCondition.getWorkidWork());
                propertyValueMapper.deleteByExample(propertyValueExample);
            }
        }
        // 4、 删除
        for (ProjectAffiliated projectAffiliated : selectByExample) {
            // 4.1 删除元件节点坐标信息
            ElementNodeExample elementNodeExample = new ElementNodeExample();
            elementNodeExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
            elementNodeMapper.deleteByExample(elementNodeExample);
            // 4.2 删除元件拓扑信息
            ElementExample elementExample = new ElementExample();
            elementExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
            elementMapper.deleteByExample(elementExample);
            // 4.3 删除工况信息
            WorkingConditionExample eorkingConditionExample = new WorkingConditionExample();
            eorkingConditionExample.createCriteria().andProjectidProaffEqualTo(projectAffiliated.getProjectidProaff());
            workingConditionMapper.deleteByExample(eorkingConditionExample);
        }

        // 删除工程备份
        for (ProjectAffiliated projectAffiliated : selectByExample) {
            projectAffiliatedMapper.deleteByPrimaryKey(projectAffiliated.getProjectidProaff());
        }

        // 删除工程表
        projectMapper.deleteByPrimaryKey(projectid);

    }

    
   @Autowired
   GetRealTimeDataUtil getConfigValueUtil;
    // 获取实时数据   
    @Override
    public Object getRealTimeData(GetRealTimeDataDTO getRealTimeDataDTO) throws Exception {
        // 插入仿真模拟方案
        Simulation simulation = new Simulation();
        simulation.setSimsourceSim(getRealTimeDataDTO.getSimsourceSim());
        simulation.setProjectidProaff(Long.parseLong(getRealTimeDataDTO.getProjectidProaff()));
        simulation.setSimulationnameSim(getRealTimeDataDTO.getSimulationnameSim());
        simulation.setCreatedateSim(new Date());
        simulation.setRemarkSim(getRealTimeDataDTO.getRemarkSim());
        SimulationMapper.insertSelective(simulation);

        // 前端站场实时数据集合
        List<StationandeLementVO> stationandelementList = getRealTimeDataDTO.getStationandelement();

        // 元件数据集合（包括井和加热炉）
        List<ElementVO> elementListTotal = new ArrayList<>();
        for (StationandeLementVO stationandeLementVO : stationandelementList) {
            List<ElementVO> elementlist = stationandeLementVO.getElementlist();
            elementListTotal.addAll(elementlist);
        }
        // 根据设备类型分组
        Map<String, List<ElementVO>> elementMapByType = elementListTotal.stream().collect(Collectors.groupingBy(ElementVO::getElementtype));

        // 1.查询条件的获取(站场名称和时间)
        String realtimedataSim = getRealTimeDataDTO.getRealtimedataSim();
        /** 封装实时数据的容器 */
        List<YardVO> yardList = new ArrayList<>(); // 站场
        List<SingleWellVO> singleWellList = new ArrayList<>(); // 井
        List<HeatingFurnaceVO> heatingFurnaceList = new ArrayList<>(); // 加热炉
        // 递归获取实时数据，并将数据放入容器中
        getConfigValueUtil.getRecursiveRealTimeData( realtimedataSim, yardList, singleWellList, heatingFurnaceList);

        /** 5.解析数据，并转化为返回需要的数据 */
        // 封装返回数据的容器
        List<RealTimeDataVO> resultList = new ArrayList<>();

        // 5.1解析站场数据
        // 合并list的容器

        List<YardVO> totalYardList = new ArrayList<>();
        // 查询的站场数据 根据站场名分组
        Map<String, List<YardVO>> yardMapByZcmc = yardList.stream().collect(Collectors.groupingBy(YardVO::getZcmc));
        // 将名称相同的站场,将编号封装到 查询数据中
        RealTimeDataUtil.foreachMapAnalysis(yardMapByZcmc,  stationandelementList);
        // 遍历站场数据封装到RealTimeDataVO中
        if (!CollectionUtils.isEmpty(stationandelementList)) {
            for (Entry<String, List<YardVO>> entry : yardMapByZcmc.entrySet()) {
                List<RealTimeDataVO> realTimeDataVOS = RealTimeDataUtil.reflectObjToRealTimeData(entry.getValue().get(0));
                resultList.addAll(realTimeDataVOS);
            }
        }


        // 5.2 解析井口数据
        // 查询的井口数据 根据井口名分组
        Map<String, List<SingleWellVO>> singleWellMapByJh = singleWellList.stream()
                .collect(Collectors.groupingBy(SingleWellVO::getJh));
        // 将名称相同的井,将编号封装到 查询数据中对象预留编号属性中
        RealTimeDataUtil.foreachMapAnalysis(singleWellMapByJh,  elementListTotal);
        // 遍历站场数据封装到RealTimeDataVO中
        if (!CollectionUtils.isEmpty(elementMapByType.get("well"))) {
            for (Entry<String, List<SingleWellVO>> entry : singleWellMapByJh.entrySet()) {
                List<RealTimeDataVO> realTimeDataVOS = RealTimeDataUtil.reflectObjToRealTimeData(entry.getValue().get(0));
                resultList.addAll(realTimeDataVOS);
            }
        }


        // 5.3 解析加热炉数据
        // 合并list的容器
        List<HeatingFurnaceVO> totalHeatingFurnaceList = new ArrayList<>();
        // 查询的井口数据 根据井口名分组
        Map<String, List<HeatingFurnaceVO>> heatingFurnaceMapByJh = heatingFurnaceList.stream()
                .collect(Collectors.groupingBy(HeatingFurnaceVO::getJrl));
        // 将名称相同的加热炉,将编号封装到 查询数据中对象预留编号属性中
        RealTimeDataUtil.foreachMapAnalysis(heatingFurnaceMapByJh, elementListTotal);
        // 遍历站场数据封装到RealTimeDataVO中
        if (!CollectionUtils.isEmpty(elementMapByType.get("heat"))) {
            for (Entry<String, List<HeatingFurnaceVO>> entry : heatingFurnaceMapByJh.entrySet()) {
                List<RealTimeDataVO> realTimeDataVOS = RealTimeDataUtil.reflectObjToRealTimeData(entry.getValue().get(0));
                resultList.addAll(realTimeDataVOS);
            }
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("simulationid",simulation.getSimulationidSim());
        map.put("elementpropertylist",resultList);
        return map;
    }

    @Override
    public Object getProjectandAffandWork() {

        // 查询工程表
        List<ProjectVO> projectVOS = projectMapper.selectAllToProjectVO();

        // 查询工程备份表
        List<ProjectaffVO> projectaffVOS = projectAffiliatedMapper.selectAllToProjectAff();
        // 根据工程表id分组
        Map<Long, List<ProjectaffVO>> mapByProject = projectaffVOS.stream().collect(Collectors.groupingBy(ProjectaffVO::getProjectid));
        for (Entry<Long, List<ProjectaffVO>> entry : mapByProject.entrySet()) {
            List<ProjectaffVO> value = entry.getValue();
            int count = value.size();
            for (int i = 0; i < value.size(); i++) {
                entry.getValue().get(i).setProjectname("备份"+(count--));
            }
        }
        // 查询工况表
        List<WorkVO> workVOS = workingConditionMapper.selectAllToWorkVO();

        // 组织数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("projectlist",projectVOS);
        map.put("projectafflist",projectaffVOS);
        map.put("worklist",workVOS);
        return map;
    }
}
