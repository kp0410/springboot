package com.ywjs.model.dto;

import java.io.Serializable;

public class ElementName implements Serializable{
    private String elementname;

    public ElementName() {}

    public ElementName(String elementname) {
        this.elementname = elementname;
    }

    public String getElementname() {
        return elementname;
    }

    public void setElementname(String elementname) {
        this.elementname = elementname;
    }
}
