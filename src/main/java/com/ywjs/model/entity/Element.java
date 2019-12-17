package com.ywjs.model.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName Element
 * @Description TODO(元件拓扑表实体) 
 * @Author 周伟
 * @Date 2019年12月3日 上午11:44:26
 */
public class Element implements Serializable {
    private Integer elementidEle;

    private String nodestarEle;

    private String nodeendEle;

    private Integer starxEle;

    private Integer staryEle;

    private Integer projectidProaff;

    private String layeridEle;

    private String elementrealnameEle;

    private String elementtypeEle;

    private Integer elementisstate;

    private static final long serialVersionUID = 1L;

    public Integer getElementidEle() {
        return elementidEle;
    }

    public void setElementidEle(Integer elementidEle) {
        this.elementidEle = elementidEle;
    }

    public String getNodestarEle() {
        return nodestarEle;
    }

    public void setNodestarEle(String nodestarEle) {
        this.nodestarEle = nodestarEle == null ? null : nodestarEle.trim();
    }

    public String getNodeendEle() {
        return nodeendEle;
    }

    public void setNodeendEle(String nodeendEle) {
        this.nodeendEle = nodeendEle == null ? null : nodeendEle.trim();
    }

    public Integer getStarxEle() {
        return starxEle;
    }

    public void setStarxEle(Integer starxEle) {
        this.starxEle = starxEle;
    }

    public Integer getStaryEle() {
        return staryEle;
    }

    public void setStaryEle(Integer staryEle) {
        this.staryEle = staryEle;
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
        this.layeridEle = layeridEle == null ? null : layeridEle.trim();
    }

    public String getElementrealnameEle() {
        return elementrealnameEle;
    }

    public void setElementrealnameEle(String elementrealnameEle) {
        this.elementrealnameEle = elementrealnameEle == null ? null : elementrealnameEle.trim();
    }

    public String getElementtypeEle() {
        return elementtypeEle;
    }

    public void setElementtypeEle(String elementtypeEle) {
        this.elementtypeEle = elementtypeEle == null ? null : elementtypeEle.trim();
    }

    public Integer getElementisstate() {
        return elementisstate;
    }

    public void setElementisstate(Integer elementisstate) {
        this.elementisstate = elementisstate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", elementidEle=").append(elementidEle);
        sb.append(", nodestarEle=").append(nodestarEle);
        sb.append(", nodeendEle=").append(nodeendEle);
        sb.append(", starxEle=").append(starxEle);
        sb.append(", staryEle=").append(staryEle);
        sb.append(", projectidProaff=").append(projectidProaff);
        sb.append(", layeridEle=").append(layeridEle);
        sb.append(", elementrealnameEle=").append(elementrealnameEle);
        sb.append(", elementtypeEle=").append(elementtypeEle);
        sb.append(", elementisstate=").append(elementisstate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}