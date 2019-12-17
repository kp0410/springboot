package com.ywjs.model.entity;

import java.io.Serializable;

public class ElementNode implements Serializable {
    private Integer nodeidNdl;

    private Integer nodexNdl;

    private Integer nodeyNdl;

    private Integer projectidProaff;

    private String layeridEle;
    
    private String nodenumNdl;
    
    public String getNodenumNdl() {
        return nodenumNdl;
    }

    
    public void setNodenumNdl(String nodenumNdl) {
        this.nodenumNdl = nodenumNdl;
    }

    private static final long serialVersionUID = 1L;

    public Integer getNodeidNdl() {
        return nodeidNdl;
    }

    public void setNodeidNdl(Integer nodeidNdl) {
        this.nodeidNdl = nodeidNdl;
    }

    public Integer getNodexNdl() {
        return nodexNdl;
    }

    public void setNodexNdl(Integer nodexNdl) {
        this.nodexNdl = nodexNdl;
    }

    public Integer getNodeyNdl() {
        return nodeyNdl;
    }

    public void setNodeyNdl(Integer nodeyNdl) {
        this.nodeyNdl = nodeyNdl;
    }

    public Integer getProjectidProaff() {
        return projectidProaff;
    }

    public void setProjectidProaff(Integer projectidProaff) {
        this.projectidProaff = projectidProaff;
    }

    public String getLayeridEle() {
        return layeridEle;
    }

    public void setLayeridEle(String layeridEle) {
        this.layeridEle = layeridEle;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", nodeidNdl=").append(nodeidNdl);
        sb.append(", nodenumNdl=").append(nodenumNdl);
        sb.append(", nodexNdl=").append(nodexNdl);
        sb.append(", nodeyNdl=").append(nodeyNdl);
        sb.append(", projectidProaff=").append(projectidProaff);
        sb.append(", layeridEle=").append(layeridEle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}