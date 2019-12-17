/**
 * @file: PipeNetworkSimulationServiceImpl.java
 * @Package： com.ywjs.service.impl
 * @Description: TODO(用一句话描述该文件做什么)
 * @author： 周伟
 * @date： 2019年11月26日 上午11:29:45
 * @version： V1.0
 * @par 版权信息：
 * 2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */
package com.ywjs.service.impl;

import com.ywjs.common.constant.CodeMsg;
import com.ywjs.common.utils.GetRealTimeDataUtil;
import com.ywjs.exception.GlobalException;
import com.ywjs.job.RealTimeSimulationJob;
import com.ywjs.mapper.*;
import com.ywjs.model.dto.IdtypeDTO;
import com.ywjs.model.dto.SetRealTiemFzmnDTO;
import com.ywjs.model.entity.*;
import com.ywjs.model.vo.RealTiemSimulationVO;
import com.ywjs.model.vo.SimulationlistVO;
import com.ywjs.model.vo.YardVO;
import com.ywjs.pythontookit.controller.GetRealtimePipesim;
import com.ywjs.service.PipeNetworkSimulationService;
import com.ywjs.service.TimedTaskService;
import com.ywjs.service.TimingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.websocket.Session;
import java.util.*;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

/**
 * @ClassName PipeNetworkSimulationServiceImpl
 * @Description TODO(管网仿真模拟实现类)
 * @Author 周伟
 * @Date 2019年11月26日 上午11:29:45
 */
@Service("pipeNetworkSimulationService")
@Transactional(rollbackFor = Exception.class)
public class PipeNetworkSimulationServiceImpl implements PipeNetworkSimulationService {

    /* 工程dao */
    @Autowired
    private ProjectMapper projectMapper;
    /* 工程备份dao */
    @Autowired
    private ProjectAffiliatedMapper projectAffiliatedMapper;
    /* 复杂查询dao */
    @Autowired
    CustomMapper customMapper;
    /* 实时仿真模拟表dao */
    @Autowired
    RealtimeSimulationMapper realtimeSimulationMapper;
    /* 元件拓扑表dao */
    @Autowired
    ElementMapper elementMapper;
    /* 属性值表dao */
    @Autowired
    PropertyValueMapper propertyValueMapper;
    // 各设备节点实时模拟结果dao
    @Autowired
    RealtimesimNodeResultTblMapper realtimesimNodeResultTblMapper;
    // 各管段实时模拟结果dao
    @Autowired
    RealtimesimPipeResultMapper realtimesimPipeResultMapper;

    /** 定时服务表 */
    @Autowired
    TimedTaskService timedTaskService;
    @Autowired
    GetRealtimePipesim getRealtimePipesim;
    @Autowired
    GetRealTimeDataUtil getConfigValueUtil;

    @Override
    public Object getSimulationList(IdtypeDTO idtypeDTO) {
        // 参数验证
        if (idtypeDTO.getIdtype() == null || idtypeDTO.getProjectid() == null) {
            throw new GlobalException(CodeMsg.PARAMETER_VALIDATION);
        }

        // 封装查询结果的容器
        List<SimulationlistVO> simulationList = null;
        // 封装查询条件
        if (idtypeDTO.getIdtype() == 1) {
            /** 工程表ID，根据工程表ID获取该工程下的所有模拟方案数据。 */
            // 查询工程ID查询仿真数据
            HashMap<String, Long> map = new HashMap<>();
            map.put("id", idtypeDTO.getProjectid());
            simulationList = customMapper.selectJointSimulation(map);
        } else if (idtypeDTO.getIdtype() == 2) {
            /** 备份表ID，，根据备份表ID获取该备份下的所有模拟方案数据。 */
            // 根据备份表ID查询仿真数据
            simulationList = customMapper.selectSimulationByAffId(idtypeDTO.getProjectid());
        } else {
            /** 获取全部的模拟方案数据 */
            simulationList = customMapper.selectJointSimulation(null);
        }
        return simulationList;
    }

    @Override
    public void setrealtiemfzmn(SetRealTiemFzmnDTO setRealTiemFzmnDTO) {
        // 判断是否有任务运行，否则关闭
        timedTaskService.stopTask(null);

        // 删除历史数据（实时仿真模拟表、实时仿真结果总表、各设备节点实时模拟结果、各管段实时模拟结果）
        realtimeSimulationMapper.deleteByExample(null);
        customMapper.deleteAllRealtimesimResult();
        realtimesimNodeResultTblMapper.deleteAll();
        realtimesimPipeResultMapper.deleteByExample(null);

        RealtimeSimulation simulation = setRealTiemFzmnDTO.getRealsimlist();

        // 1.实时仿真模拟表入库
        RealtimeSimulation realsim = setRealTiemFzmnDTO.getRealsimlist();
        realsim.setCreatedateRealsim(new Date());
        realtimeSimulationMapper.insertSelective(realsim);

        // 2. 读取方案设备
        // 2.1 根据工程备份表ID获取元件拓扑表中的元件编号（站场、井、加热炉），限制条件元件类型：8是 站场；元件类型：2是 井；元件类型：7 是加热炉
        List<String> condition = Arrays.asList(new String[]{"2", "7", "8"}); // 限制条件
        ElementExample elementExample = new ElementExample();
        elementExample.createCriteria().andProjectidProaffEqualTo(simulation.getProjectidProaff())
                .andElementtypeEleIn(condition);
        List<Element> listElement = elementMapper.selectByExample(elementExample);

        // 2.2 查询属性为名称（属性id为0）对应的属性值 （查询条件属性id+工况id+元件编号）
        // 获取传入参数中的工况id
        Long workid = simulation.getWorkidWork();
        List<RealTiemSimulationVO> listRealTiemSimulationVO = new ArrayList<>();
        for (Element element : listElement) {
            String elementrealnameEle = element.getElementrealnameEle(); // 元件编号
            PropertyValueExample propertyValueExample = new PropertyValueExample();
            propertyValueExample.createCriteria().andElementrealnameEleEqualTo(elementrealnameEle)
                    .andWorkidWorkEqualTo(workid).andPropertyidProEqualTo(51);
            // 该条件能唯一确定一条数据，获取list中的第一条就行
            List<PropertyValue> elementnameList = propertyValueMapper.selectByExample(propertyValueExample);

            PropertyValueExample example = new PropertyValueExample();
            example.createCriteria().andElementrealnameEleEqualTo(elementrealnameEle)
                    .andWorkidWorkEqualTo(workid).andPropertyidProEqualTo(0);
            // 该条件能唯一确定一条数据，获取list中的第一条就行,
            List<PropertyValue> pipemNameList = propertyValueMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(elementnameList) && !CollectionUtils.isEmpty(pipemNameList)) {
                String pipemName = pipemNameList.get(0).getProvalueProval();
                PropertyValue propertyValue = elementnameList.get(0);
                String elementname = propertyValue.getProvalueProval(); // 获取elementname
                listRealTiemSimulationVO.add(new RealTiemSimulationVO(elementname, elementrealnameEle, pipemName));
            }
        }

        // 分组
        Map<String, List<RealTiemSimulationVO>> listMap = listRealTiemSimulationVO.stream().collect(Collectors.groupingBy(RealTiemSimulationVO::getElementname));


//        timingService.startRealTimeSimulation("0/5 * * * * ? ", listRealTiemSimulationVO, getRealtimePipesim,
//                realsim.getSimulationidRealsim());
        // 获取实时数据，组织返回数据
        // 定时器实时调用,每次调用关闭上次的，启动一个新的定时任务
        Map<Session, ScheduledFuture> map = timedTaskService.getScheduledFutureBySession();
        if (map.size() > 0 && map.get(null) != null) {
            timedTaskService.stopTask(null);
        }
        RealTimeSimulationJob job = new RealTimeSimulationJob(getConfigValueUtil, listMap, getRealtimePipesim, realsim.getSimulationidRealsim());
        // 覆盖任务
        timedTaskService.startTask(null, job, 0, 60);

    }

}
