/** 
 * @file: PipeNetworkModelService.java 
 * @Package： com.ywjs.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月12日 下午3:55:04 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.service;

import java.util.HashMap;
import java.util.List;

import com.ywjs.model.dto.GetRealTimeDataDTO;
import com.ywjs.model.dto.SaveProjectDTO;
import com.ywjs.model.entity.EarlyWarning;
import com.ywjs.model.entity.Project;
import com.ywjs.model.entity.ProjectAffiliated;

/**
 * @ClassName PipeNetworkModelService
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年11月12日 下午3:55:04
 */
public interface PipeNetworkModelService {
    
    /**
     * 
     * @Description: TODO(新建工程模型) 
     * @author： 2019年11月12日  周伟  创建初始版本
     * @param project
     * @return
     */
    public HashMap<String, Long> savaNewProject(Project project);
    
    /**
     * @Description: TODO(获取全部工程模型) 
     * @author： 2019年11月12日  周伟  创建初始版本
     * @param project
     * @return
     */
    public List<Project> getProject();

    /**
     * @Description: TODO(获取属性列表及属性与元件对应关系) 
     * @author： 2019年11月12日  周伟  创建初始版本
     */
    public HashMap<String, Object> getAttributeList();

    /**
     * @Description: TODO(保存项目工程) 
     * @author： 2019年11月14日  周伟  创建初始版本
     * @param saveProjectDTO
     */
    public Long saveProject(SaveProjectDTO saveProjectDTO);

    /**
     * @Description: 获取工程备份列表信息
     * @author： 2019年11月14日  周伟  创建初始版本
     * @return
     */
    public List<ProjectAffiliated> getProaffByProjectIdList(Long projectid);

    /**
     * @Description: TODO(根据工程表ID打开项目) 
     * @author： 2019年11月14日  周伟  创建初始版本
     * @param projectid
     * @param idtype
     * @return
     */
    public Object openProjectByProjectId(Long projectid, Integer idtype);

    /**
     * @Description: 根据工程表ID获取工程备份表条数
     * @author： 2019年11月15日  周伟  创建初始版本
     * @param projectid
     * @return 
     */
    public int proaffCountByProjectId(Long projectid);

    /**
     * @Description: TODO(根据工程表ID删除备份表及其他相关数据) 
     * @author： 2019年11月15日  周伟  创建初始版本
     * @param projectid
     * @return
     */
    public void deleteProjectByProjectId(Long projectid);

    /**
     * @Description: TODO(获取实时数据) 
     * @author： 2019年11月27日  周伟  创建初始版本
     * @param getRealTimeDataDTO
     * @return
     */
    public Object getRealTimeData(GetRealTimeDataDTO getRealTimeDataDTO) throws Exception;

    /**
     *  获取工程表与工程备份表与工况表数据
     * @return
     */
    public Object getProjectandAffandWork();
}
