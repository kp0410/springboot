package com.ywjs.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectAffiliated implements Serializable {
    private Long projectidProaff; //备份ID

    private Long projectidPro; //工程ID

    private Date createdateProaff; //创建时间

    private String prousernameProaff; //用户名
 
    private String remarkProaff; //备注

    private Integer issaveProaff; //是否保存
    
    private List<Simulation> SimulationList; //仿真模拟方案

    private static final long serialVersionUID = 1L;

    public Long getProjectidProaff() {
        return projectidProaff;
    }

    public void setProjectidProaff(Long projectidProaff) {
        this.projectidProaff = projectidProaff;
    }

    public Long getProjectidPro() {
        return projectidPro;
    }

    public void setProjectidPro(Long projectidPro) {
        this.projectidPro = projectidPro;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreatedateProaff() {
        return createdateProaff;
    }

    public void setCreatedateProaff(Date createdateProaff) {
        this.createdateProaff = createdateProaff;
    }

    public String getProusernameProaff() {
        return prousernameProaff;
    }

    public void setProusernameProaff(String prousernameProaff) {
        this.prousernameProaff = prousernameProaff == null ? null : prousernameProaff.trim();
    }

    public String getRemarkProaff() {
        return remarkProaff;
    }

    public void setRemarkProaff(String remarkProaff) {
        this.remarkProaff = remarkProaff == null ? null : remarkProaff.trim();
    }

    public Integer getIssaveProaff() {
        return issaveProaff;
    }

    public void setIssaveProaff(Integer issaveProaff) {
        this.issaveProaff = issaveProaff;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectidProaff=").append(projectidProaff);
        sb.append(", projectidPro=").append(projectidPro);
        sb.append(", createdateProaff=").append(createdateProaff);
        sb.append(", prousernameProaff=").append(prousernameProaff);
        sb.append(", remarkProaff=").append(remarkProaff);
        sb.append(", issaveProaff=").append(issaveProaff);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}