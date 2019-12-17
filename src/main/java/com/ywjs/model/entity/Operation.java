package com.ywjs.model.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @ClassName Operation
 * @Description TODO(管网运行优选方案管理实体) 
 * @Author 周伟
 * @Date 2019年11月26日 下午4:08:08
 */
public class Operation implements Serializable {
    private Long operaidOpera; //id

    private String operanameOpera; //方案名称

    private Long projectidProaff; //工程备份表编号

    private String operausernameOpera;//创建用户名

    private Date createdateSim; //方案创建时间

    private String remarkOpera; //该方案创建时的填写备注

    private static final long serialVersionUID = 1L;

    public Long getOperaidOpera() {
        return operaidOpera;
    }

    public void setOperaidOpera(Long operaidOpera) {
        this.operaidOpera = operaidOpera;
    }

    public String getOperanameOpera() {
        return operanameOpera;
    }

    public void setOperanameOpera(String operanameOpera) {
        this.operanameOpera = operanameOpera == null ? null : operanameOpera.trim();
    }

    public Long getProjectidProaff() {
        return projectidProaff;
    }

    public void setProjectidProaff(Long projectidProaff) {
        this.projectidProaff = projectidProaff;
    }

    public String getOperausernameOpera() {
        return operausernameOpera;
    }

    public void setOperausernameOpera(String operausernameOpera) {
        this.operausernameOpera = operausernameOpera == null ? null : operausernameOpera.trim();
    }

    public Date getCreatedateSim() {
        return createdateSim;
    }

    public void setCreatedateSim(Date createdateSim) {
        this.createdateSim = createdateSim;
    }

    public String getRemarkOpera() {
        return remarkOpera;
    }

    public void setRemarkOpera(String remarkOpera) {
        this.remarkOpera = remarkOpera == null ? null : remarkOpera.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operaidOpera=").append(operaidOpera);
        sb.append(", operanameOpera=").append(operanameOpera);
        sb.append(", projectidProaff=").append(projectidProaff);
        sb.append(", operausernameOpera=").append(operausernameOpera);
        sb.append(", createdateSim=").append(createdateSim);
        sb.append(", remarkOpera=").append(remarkOpera);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}