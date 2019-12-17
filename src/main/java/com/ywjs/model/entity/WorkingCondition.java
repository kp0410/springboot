package com.ywjs.model.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @ClassName WorkingCondition
 * @Description TODO(工况实体类) 
 * @Author 周伟
 * @Date 2019年11月26日 下午4:21:49
 */
public class WorkingCondition implements Serializable {
    private Long workidWork; //工况ID

    private String workusernameWork; //用户名

    //@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss")
    private Date createdateWork; //创建时间

    private Integer worktypeWork; //0:普通工况信息，1：用户自建工况，2：优化后形成新的一套工况，

    private Integer isacquiesceWork; //是否是默认工况  0:是 其他：不是
    
    private String remarkProaff; //备注

    private Long projectidProaff; //备份表ID

    private String worknameWork; //工况名称

    private static final long serialVersionUID = 1L;

    public Long getWorkidWork() {
        return workidWork;
    }

    public void setWorkidWork(Long workidWork) {
        this.workidWork = workidWork;
    }

    public String getWorkusernameWork() {
        return workusernameWork;
    }

    public void setWorkusernameWork(String workusernameWork) {
        this.workusernameWork = workusernameWork == null ? null : workusernameWork.trim();
    }

    public Date getCreatedateWork() {
        return createdateWork;
    }

    public void setCreatedateWork(Date createdateWork) {
        this.createdateWork = createdateWork;
    }

    public Integer getWorktypeWork() {
        return worktypeWork;
    }

    public void setWorktypeWork(Integer worktypeWork) {
        this.worktypeWork = worktypeWork;
    }

    public Integer getIsacquiesceWork() {
        return isacquiesceWork;
    }

    public void setIsacquiesceWork(Integer isacquiesceWork) {
        this.isacquiesceWork = isacquiesceWork;
    }

    public String getRemarkProaff() {
        return remarkProaff;
    }

    public void setRemarkProaff(String remarkProaff) {
        this.remarkProaff = remarkProaff == null ? null : remarkProaff.trim();
    }

    public Long getProjectidProaff() {
        return projectidProaff;
    }

    public void setProjectidProaff(Long projectidProaff) {
        this.projectidProaff = projectidProaff;
    }

    public String getWorknameWork() {
        return worknameWork;
    }

    public void setWorknameWork(String worknameWork) {
        this.worknameWork = worknameWork == null ? null : worknameWork.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workidWork=").append(workidWork);
        sb.append(", workusernameWork=").append(workusernameWork);
        sb.append(", createdateWork=").append(createdateWork);
        sb.append(", worktypeWork=").append(worktypeWork);
        sb.append(", isacquiesceWork=").append(isacquiesceWork);
        sb.append(", remarkProaff=").append(remarkProaff);
        sb.append(", projectidProaff=").append(projectidProaff);
        sb.append(", worknameWork=").append(worknameWork);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}