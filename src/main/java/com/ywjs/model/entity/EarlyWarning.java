package com.ywjs.model.entity;

import java.io.Serializable;

public class EarlyWarning implements Serializable {
    private Long earwaridEarwar;

    private String projectidProaff;

    private String layeridEarwar;

    private String elementrealnameEarwar;

    private String experienceEarwar;

    private String propertyidPro;

    private Integer settingEarwar;

    private Integer criticallowEarwar;

    private Integer criticalhighEarwar;
    
    //外加字段，用于展示属性名称
    private String  propertyName;

    private static final long serialVersionUID = 1L;

    
    public String getPropertyName() {
        return propertyName;
    }

    
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public Long getEarwaridEarwar() {
        return earwaridEarwar;
    }

    public void setEarwaridEarwar(Long earwaridEarwar) {
        this.earwaridEarwar = earwaridEarwar;
    }

    public String getProjectidProaff() {
        return projectidProaff;
    }

    public void setProjectidProaff(String projectidProaff) {
        this.projectidProaff = projectidProaff == null ? null : projectidProaff.trim();
    }

    public String getLayeridEarwar() {
        return layeridEarwar;
    }

    public void setLayeridEarwar(String layeridEarwar) {
        this.layeridEarwar = layeridEarwar == null ? null : layeridEarwar.trim();
    }

    public String getElementrealnameEarwar() {
        return elementrealnameEarwar;
    }

    public void setElementrealnameEarwar(String elementrealnameEarwar) {
        this.elementrealnameEarwar = elementrealnameEarwar == null ? null : elementrealnameEarwar.trim();
    }

    public String getExperienceEarwar() {
        return experienceEarwar;
    }

    public void setExperienceEarwar(String experienceEarwar) {
        this.experienceEarwar = experienceEarwar == null ? null : experienceEarwar.trim();
    }

    public String getPropertyidPro() {
        return propertyidPro;
    }

    public void setPropertyidPro(String propertyidPro) {
        this.propertyidPro = propertyidPro == null ? null : propertyidPro.trim();
    }

    public Integer getSettingEarwar() {
        return settingEarwar;
    }

    public void setSettingEarwar(Integer settingEarwar) {
        this.settingEarwar = settingEarwar;
    }

    public Integer getCriticallowEarwar() {
        return criticallowEarwar;
    }

    public void setCriticallowEarwar(Integer criticallowEarwar) {
        this.criticallowEarwar = criticallowEarwar;
    }

    public Integer getCriticalhighEarwar() {
        return criticalhighEarwar;
    }

    public void setCriticalhighEarwar(Integer criticalhighEarwar) {
        this.criticalhighEarwar = criticalhighEarwar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", earwaridEarwar=").append(earwaridEarwar);
        sb.append(", propertyidPro=").append(propertyidPro);
        sb.append(", projectidProaff=").append(projectidProaff);
        sb.append(", layeridEarwar=").append(layeridEarwar);
        sb.append(", elementrealnameEarwar=").append(elementrealnameEarwar);
        sb.append(", experienceEarwar=").append(experienceEarwar);
        sb.append(", propertyidPro=").append(propertyidPro);
        sb.append(", settingEarwar=").append(settingEarwar);
        sb.append(", criticallowEarwar=").append(criticallowEarwar);
        sb.append(", criticalhighEarwar=").append(criticalhighEarwar);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}