package com.ywjs.model.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName RealtimeSimulation
 * @Description TODO(实时模拟数据实体类) 
 * @Author 周伟
 * @Date 2019年12月3日 上午10:58:31
 */
public class RealtimeSimulation implements Serializable {
    private Long simulationidRealsim; // 编号

    private String simulationnameRealsim; //方案名称

    private Long projectidProaff;// 工程备份表ID

    private Long workidWork; // 工况表编号

    private Date createdateRealsim; //创建时间

    private String remarkRealsim; //备注

    public Long getSimulationidRealsim() {
        return simulationidRealsim;
    }

    public void setSimulationidRealsim(Long simulationidRealsim) {
        this.simulationidRealsim = simulationidRealsim;
    }

    public String getSimulationnameRealsim() {
        return simulationnameRealsim;
    }

    public void setSimulationnameRealsim(String simulationnameRealsim) {
        this.simulationnameRealsim = simulationnameRealsim == null ? null : simulationnameRealsim.trim();
    }

    public Long getProjectidProaff() {
        return projectidProaff;
    }

    public void setProjectidProaff(Long projectidProaff) {
        this.projectidProaff = projectidProaff;
    }

    public Long getWorkidWork() {
        return workidWork;
    }

    public void setWorkidWork(Long workidWork) {
        this.workidWork = workidWork;
    }

    public Date getCreatedateRealsim() {
        return createdateRealsim;
    }

    public void setCreatedateRealsim(Date createdateRealsim) {
        this.createdateRealsim = createdateRealsim;
    }

    public String getRemarkRealsim() {
        return remarkRealsim;
    }

    public void setRemarkRealsim(String remarkRealsim) {
        this.remarkRealsim = remarkRealsim == null ? null : remarkRealsim.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", simulationidRealsim=").append(simulationidRealsim);
        sb.append(", simulationnameRealsim=").append(simulationnameRealsim);
        sb.append(", projectidProaff=").append(projectidProaff);
        sb.append(", workidWork=").append(workidWork);
        sb.append(", createdateRealsim=").append(createdateRealsim);
        sb.append(", remarkRealsim=").append(remarkRealsim);
        sb.append("]");
        return sb.toString();
    }
}