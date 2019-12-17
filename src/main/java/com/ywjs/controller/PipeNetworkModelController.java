/**
 * @file: PipeNetworkModelController.java
 * @Package： com.ywjs.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author： 周伟
 * @date： 2019年11月11日 下午4:41:49
 * @version： V1.0
 * @par 版权信息：
 * 2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */
package com.ywjs.controller;

import com.ywjs.common.vo.Result;
import com.ywjs.model.dto.EncGetRealTimeDataDTO;
import com.ywjs.model.dto.IdtypeDTO;
import com.ywjs.model.dto.SaveProjectDTO;
import com.ywjs.model.entity.Project;
import com.ywjs.model.entity.ProjectAffiliated;
import com.ywjs.service.PipeNetworkModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

//import com.ywjs.model.dto.EncGetRealTimeDataDTO;

/**
 * @ClassName PipeNetworkModelController
 * @Description TODO(管网物理模型管理Controller类)
 * @Author 周伟
 * @Date 2019年11月11日 下午4:41:49
 */
@RestController
@RequestMapping("/gwwlmxgl")
public class PipeNetworkModelController {

    @Autowired
    private PipeNetworkModelService pipeNetworkModelService;

    @PostMapping(value = "/newProject")
    // @RequestMapping(value = "/newProject" , method = RequestMethod.POST)
    public Result newProject(@RequestBody Project project) {
        HashMap<String, Long> savaNewProject = pipeNetworkModelService.savaNewProject(project);
        return Result.success(savaNewProject);
    }

    @PostMapping(value = "/getProject")
    public Result getProject() {
        List<Project> listPro = pipeNetworkModelService.getProject();
        return Result.build(200, "查询成功", listPro);
    }

    /**
     * @return
     * @Description: TODO(获取属性列表和属性与元件对应关系表数据)
     * @author： 2019年11月13日 周伟 创建初始版本
     */
    @RequestMapping("/getAttributeList")
    public Result getAttributeList() {
        HashMap<String, Object> attributeList = pipeNetworkModelService.getAttributeList();
        return Result.build(200, "查询成功", attributeList);
    }

    /**
     * @param saveProjectDTO
     * @return
     * @Description: 保存项目工程
     * @author： 2019年11月14日 周伟 创建初始版本
     */
    @RequestMapping("/saveProject")
    public Result saveProject(@RequestBody SaveProjectDTO saveProjectDTO) {
        Long projectid = pipeNetworkModelService.saveProject(saveProjectDTO);
        return Result.build(200, "保存成功", projectid);
    }

    /**
     * @return
     * @Description: 获取工程备份列表信息
     * @author： 2019年11月14日 周伟 创建初始版本
     */
    @RequestMapping("/getProaffByProjectidList")
    public Result getProaffByProjectIdList(@RequestBody SaveProjectDTO saveProjectDTO) {
        List<ProjectAffiliated> projectAffiliatedList = pipeNetworkModelService.getProaffByProjectIdList(saveProjectDTO.getProjectid());
        return Result.build(200, "获取成功", projectAffiliatedList);
    }

    /**
     * @return
     * @Description: 根据工程表ID打开项目
     * @author： 2019年11月14日 周伟 创建初始版本
     */
    @RequestMapping("/openProjectByProjectId")
    public Result openProjectByProjectId(@RequestBody IdtypeDTO idtypeDTO) {
        Object object = pipeNetworkModelService.openProjectByProjectId(idtypeDTO.getProjectid(), idtypeDTO.getIdtype());
        return Result.build(200, "打开成功", object);
    }

    /**
     * @return
     * @Description: 根据工程表ID获取工程备份表条数
     * @author： 2019年11月14日 周伟 创建初始版本
     */
    @RequestMapping("/proaffCountByProjectId")
    public Result proaffCountByProjectId(@RequestBody IdtypeDTO idtypeDTO) {
        int proaffCount = pipeNetworkModelService.proaffCountByProjectId(idtypeDTO.getProjectid());
        return Result.build(200, "查询成功", proaffCount);
    }

    /**
     * @param
     * @return
     * @Description: TODO(根据工程表ID删除备份表及其他相关数据)
     * @author： 2019年11月26日  周伟  创建初始版本
     */
    @RequestMapping("/deleteProjectByProjectId")
    public Result deleteProjectByProjectId(@RequestBody IdtypeDTO idtypeDTO) {
        pipeNetworkModelService.deleteProjectByProjectId(idtypeDTO.getProjectid());
        return Result.build(200, "删除成功", null);
    }


    /**
     * @param
     * @return
     * @throws Exception
     * @Description: TODO(获取实时数据)
     * @author： 2019年11月26日  周伟  创建初始版本
     */
    @PostMapping("/getRealTimeData")
    public Result getRealTimeData(@RequestBody EncGetRealTimeDataDTO encGetRealTimeDataDTOmeDataDTO) throws Exception {
        Object object = pipeNetworkModelService.getRealTimeData(encGetRealTimeDataDTOmeDataDTO.getStationandelementlist());
        return Result.success(object);
    }

    /**
     * 获取工程表与工程备份表与工况表数据
     * @return
     */
    @RequestMapping("/getProjectandAffandWork")
    public Result getProjectandAffandWork()  {
        Object object = pipeNetworkModelService.getProjectandAffandWork();
        return Result.success(object);
    }


}
