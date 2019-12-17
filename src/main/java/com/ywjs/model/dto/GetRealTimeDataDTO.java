/** 
 * @file: getRealTimeDataDTO.java 
 * @Package： com.ywjs.model.dto 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月26日 上午10:34:13 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ywjs.model.vo.PipelineVO;
import com.ywjs.model.vo.StationandeLementVO;

/**
 * @ClassName getRealTimeDataDTO
 * @Description TODO(获取实时数据请求参数的数据传输对象) 
 * @Author 周伟
 * @Date 2019年11月26日 上午10:34:13
 */
public class GetRealTimeDataDTO implements Serializable{
    private String simsourceSim;//方案来源
    private String projectidProaff;//工程备份表编号
    private String simulationnameSim;//方案名称
    private String realtimedataSim; //实时数据获取时间
    private String remarkSim; //备注
    private List<StationandeLementVO> stationandelement; //站场与设备列表
    private List<PipelineVO> pipelinelist; //管线集合
    public String getSimsourceSim() {
        return simsourceSim;
    }
    public List<PipelineVO> getPipelinelist() {
        return pipelinelist;
    }

    public void setPipelinelist(List<PipelineVO> pipelinelist) {
        this.pipelinelist = pipelinelist;
    }
    public void setSimsourceSim(String simsourceSim) {
        this.simsourceSim = simsourceSim;
    }
    
    public String getProjectidProaff() {
        return projectidProaff;
    }
    
    public void setProjectidProaff(String projectidProaff) {
        this.projectidProaff = projectidProaff;
    }
    
    public String getSimulationnameSim() {
        return simulationnameSim;
    }
    
    public void setSimulationnameSim(String simulationnameSim) {
        this.simulationnameSim = simulationnameSim;
    }
    
    public String getRealtimedataSim() {
        return realtimedataSim;
    }
    
    public void setRealtimedataSim(String realtimedataSim) {
        this.realtimedataSim = realtimedataSim;
    }
    
    public String getRemarkSim() {
        return remarkSim;
    }
    
    public void setRemarkSim(String remarkSim) {
        this.remarkSim = remarkSim;
    }
    
    public List<StationandeLementVO> getStationandelement() {
        return stationandelement;
    }
    
    public void setStationandelement(List<StationandeLementVO> stationandelement) {
        this.stationandelement = stationandelement;
    }

    @Override
    public String toString() {
        return "GetRealTimeDataDTO [simsourceSim=" + simsourceSim + ", projectidProaff=" + projectidProaff
                + ", simulationnameSim=" + simulationnameSim + ", realtimedataSim=" + realtimedataSim + ", remarkSim="
                + remarkSim + ", stationandelement=" + stationandelement + "]";
    }
    
    
}
