package com.ywjs.model.entity;

import java.io.Serializable;
import java.util.Date;

public class Simulation implements Serializable {
    private Long simulationidSim; //仿真id

    private Long projectidProaff;  //备份id

    private String simulationnameSim; //方案名称

    private String simsourceSim; //来自某个工况

    private String simusernameSim; //用户名

    private Date createdateSim;  //创建时间

    private String remarkSim; //备注
    
    /** 额外字段*/
    private Date createdateProaff; //备份表时间
    private String projectnamePro; //工程名称
    private Long ProjectidPro; //工程id
    
    
    private static final long serialVersionUID = 1L;
    
    public Date getCreatedateProaff() {
        return createdateProaff;
    }

    
    public void setCreatedateProaff(Date createdateProaff) {
        this.createdateProaff = createdateProaff;
    }

    
    public String getProjectnamePro() {
        return projectnamePro;
    }

    
    public void setProjectnamePro(String projectnamePro) {
        this.projectnamePro = projectnamePro;
    }

    
    public Long getProjectidPro() {
        return ProjectidPro;
    }

    
    public void setProjectidPro(Long projectidPro) {
        ProjectidPro = projectidPro;
    }

    public Long getSimulationidSim() {
        return simulationidSim;
    }

    public void setSimulationidSim(Long simulationidSim) {
        this.simulationidSim = simulationidSim;
    }

    public Long getProjectidProaff() {
        return projectidProaff;
    }

    public void setProjectidProaff(Long projectidProaff) {
        this.projectidProaff = projectidProaff;
    }

    public String getSimulationnameSim() {
        return simulationnameSim;
    }

    public void setSimulationnameSim(String simulationnameSim) {
        this.simulationnameSim = simulationnameSim == null ? null : simulationnameSim.trim();
    }

    public String getSimsourceSim() {
        return simsourceSim;
    }

    public void setSimsourceSim(String simsourceSim) {
        this.simsourceSim = simsourceSim == null ? null : simsourceSim.trim();
    }

    public String getSimusernameSim() {
        return simusernameSim;
    }

    public void setSimusernameSim(String simusernameSim) {
        this.simusernameSim = simusernameSim == null ? null : simusernameSim.trim();
    }

    public Date getCreatedateSim() {
        return createdateSim;
    }

    public void setCreatedateSim(Date createdateSim) {
        this.createdateSim = createdateSim;
    }

    public String getRemarkSim() {
        return remarkSim;
    }

    public void setRemarkSim(String remarkSim) {
        this.remarkSim = remarkSim == null ? null : remarkSim.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", simulationidSim=").append(simulationidSim);
        sb.append(", projectidProaff=").append(projectidProaff);
        sb.append(", simulationnameSim=").append(simulationnameSim);
        sb.append(", simsourceSim=").append(simsourceSim);
        sb.append(", simusernameSim=").append(simusernameSim);
        sb.append(", createdateSim=").append(createdateSim);
        sb.append(", remarkSim=").append(remarkSim);
        sb.append(", createdateProaff=").append(createdateProaff);
        sb.append(", projectnamePro=").append(projectnamePro);
        sb.append(", ProjectidPro=").append(ProjectidPro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}