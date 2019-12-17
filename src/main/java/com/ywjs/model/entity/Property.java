package com.ywjs.model.entity;

import java.io.Serializable;

public class Property implements Serializable {
    private Long id;

    private String title;

    private String name;

    private String unit;

    private String value;

    private String remarkPro;

    private Integer editable;

    private Long opendilaog;

    private Integer show;
    
    private Integer arcMode;

    
    public Integer getArcMode() {
        return arcMode;
    }

    
    public void setArcMode(Integer arcMode) {
        this.arcMode = arcMode;
    }


    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getTitle() {
        return title;
    }

    
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String name) {
        this.name = name;
    }

    
    public String getUnit() {
        return unit;
    }

    
    public void setUnit(String unit) {
        this.unit = unit;
    }

    
    public String getValue() {
        return value;
    }

    
    public void setValue(String value) {
        this.value = value;
    }

    
    public String getRemarkPro() {
        return remarkPro;
    }

    
    public void setRemarkPro(String remarkPro) {
        this.remarkPro = remarkPro;
    }

    
    public Integer getEditable() {
        return editable;
    }

    
    public void setEditable(Integer editable) {
        this.editable = editable;
    }

    
    public Long getOpendilaog() {
        return opendilaog;
    }

    
    public void setOpendilaog(Long opendilaog) {
        this.opendilaog = opendilaog;
    }

    
    public Integer getShow() {
        return show;
    }

    
    public void setShow(Integer show) {
        this.show = show;
    }



    @Override
    public String toString() {
        return "Property [id=" + id + ", title=" + title + ", name=" + name + ", unit=" + unit + ", value=" + value
                + ", remarkPro=" + remarkPro + ", editable=" + editable + ", opendilaog=" + opendilaog + ", show="
                + show + ", arcMode=" + arcMode + "]";
    }


    

    

    
}