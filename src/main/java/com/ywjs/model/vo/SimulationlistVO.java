/** 
 * @file: SimulationlistVO.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月26日 上午11:52:17 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;

import java.io.Serializable;

/**
 * @ClassName SimulationlistVO
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年11月26日 上午11:52:17
 */
public class SimulationlistVO implements Serializable{
    
    //工程表ID
    private Integer projectidPro;
    //工程备份表ID
    private String projectidProaff;
    //工程名称
    private String projectnamePro;
    //工程备份时间
    private String createdateProaff;
    //仿真模拟方案名称
    private String simulationnameSim;
    //方案来源
    private String simsourceSim;
    //仿真模拟用户名
    private String simusernameSim;
    //仿真模拟创建时间
    private String createdateSim;
    //仿真模拟方案备注
    private String remarkSim;

    public String getSimulationidSim() {
        return simulationidSim;
    }

    public void setSimulationidSim(String simulationidSim) {
        this.simulationidSim = simulationidSim;
    }

    //仿真模拟方案编号
    private String simulationidSim;
    
    public Integer getProjectidPro() {
        return projectidPro;
    }
    
    public void setProjectidPro(Integer projectidPro) {
        this.projectidPro = projectidPro;
    }
    
    public String getProjectidProaff() {
        return projectidProaff;
    }
    
    public void setProjectidProaff(String projectidProaff) {
        this.projectidProaff = projectidProaff;
    }
    
    public String getProjectnamePro() {
        return projectnamePro;
    }
    
    public void setProjectnamePro(String projectnamePro) {
        this.projectnamePro = projectnamePro;
    }
    
    public String getCreatedateProaff() {
        return createdateProaff;
    }
    
    public void setCreatedateProaff(String createdateProaff) {
        this.createdateProaff = createdateProaff;
    }
    
    public String getSimulationnameSim() {
        return simulationnameSim;
    }
    
    public void setSimulationnameSim(String simulationnameSim) {
        this.simulationnameSim = simulationnameSim;
    }
    
    public String getSimsourceSim() {
        return simsourceSim;
    }
    
    public void setSimsourceSim(String simsourceSim) {
        this.simsourceSim = simsourceSim;
    }
    
    public String getSimusernameSim() {
        return simusernameSim;
    }
    
    public void setSimusernameSim(String simusernameSim) {
        this.simusernameSim = simusernameSim;
    }
    
    public String getCreatedateSim() {
        return createdateSim;
    }
    
    public void setCreatedateSim(String createdateSim) {
        this.createdateSim = createdateSim;
    }
    
    public String getRemarkSim() {
        return remarkSim;
    }
    
    public void setRemarkSim(String remarkSim) {
        this.remarkSim = remarkSim;
    }

    @Override
    public String toString() {
        return "SimulationlistVO [projectidPro=" + projectidPro + ", projectidProaff=" + projectidProaff
                + ", projectnamePro=" + projectnamePro + ", createdateProaff=" + createdateProaff
                + ", simulationnameSim=" + simulationnameSim + ", simsourceSim=" + simsourceSim + ", simusernameSim="
                + simusernameSim + ", createdateSim=" + createdateSim + ", simulationidSim="+simulationidSim+", remarkSim=" + remarkSim + "]";
    }
    
    
    

}
