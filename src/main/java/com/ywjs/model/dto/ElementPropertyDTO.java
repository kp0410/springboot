package com.ywjs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ElementPropertyDTO implements Serializable{

    private String elementname;

    private String elementid;

    private Integer elementtype;

    private String propertykey;

    private Double propertyvalue;

    public String getElementname() {
        return elementname;
    }

    public void setElementname(String elementname) {
        this.elementname = elementname;
    }

    public String getElementid() {
        return elementid;
    }

    public void setElementid(String elementid) {
        this.elementid = elementid;
    }

    public Integer getElementtype() {
        return elementtype;
    }

    public void setElementtype(Integer elementtype) {
        this.elementtype = elementtype;
    }

    public String getPropertykey() {
        return propertykey;
    }

    public void setPropertykey(String propertykey) {
        this.propertykey = propertykey;
    }

    public Double getPropertyvalue() {
        return propertyvalue;
    }

    public void setPropertyvalue(Double propertyvalue) {
        this.propertyvalue = propertyvalue;
    }
}
