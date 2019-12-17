package com.ywjs.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Project implements Serializable {
    private Long projectidPro;

    @NotNull
    private String projectnamePro;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdatePro;

    private String prousernamePro;

    private String remarkPro;
    
    private List<ProjectAffiliated> projectAffiliatedList;

    private static final long serialVersionUID = 1L;

    public List<ProjectAffiliated> getProjectAffiliatedList() {
        return projectAffiliatedList;
    }

    
    public void setProjectAffiliatedList(List<ProjectAffiliated> projectAffiliatedList) {
        this.projectAffiliatedList = projectAffiliatedList;
    }

    public Long getProjectidPro() {
        return projectidPro;
    }

    public void setProjectidPro(Long projectidPro) {
        this.projectidPro = projectidPro;
    }

    public String getProjectnamePro() {
        return projectnamePro;
    }

    public void setProjectnamePro(String projectnamePro) {
        this.projectnamePro = projectnamePro == null ? null : projectnamePro.trim();
    }

    public Date getCreatedatePro() {
        return createdatePro;
    }

    public void setCreatedatePro(Date createdatePro) {
        this.createdatePro = createdatePro;
    }

    public String getProusernamePro() {
        return prousernamePro;
    }

    public void setProusernamePro(String prousernamePro) {
        this.prousernamePro = prousernamePro == null ? null : prousernamePro.trim();
    }

    public String getRemarkPro() {
        return remarkPro;
    }

    public void setRemarkPro(String remarkPro) {
        this.remarkPro = remarkPro == null ? null : remarkPro.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", projectidPro=").append(projectidPro);
        sb.append(", projectnamePro=").append(projectnamePro);
        sb.append(", createdatePro=").append(createdatePro);
        sb.append(", prousernamePro=").append(prousernamePro);
        sb.append(", remarkPro=").append(remarkPro);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append(", projectAffiliatedList=").append(projectAffiliatedList);
        sb.append("]");
        return sb.toString();
    }
    
}