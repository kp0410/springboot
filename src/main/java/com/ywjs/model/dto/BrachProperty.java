package com.ywjs.model.dto;

import java.io.Serializable;
import java.util.List;

public class BrachProperty implements Serializable{


    private String pipeidSimpiperes;//管线编号

    private String pipeName;//管线名称

    private List<PipesimProperty>  propertylist;

    public BrachProperty() {}

    public BrachProperty(String pipeidSimpiperes, String pipeName, List<PipesimProperty> propertylist) {
        this.pipeidSimpiperes = pipeidSimpiperes;
        this.pipeName = pipeName;
        this.propertylist = propertylist;
    }

    public String getPipeidSimpiperes() {
        return pipeidSimpiperes;
    }

    public void setPipeidSimpiperes(String pipeidSimpiperes) {
        this.pipeidSimpiperes = pipeidSimpiperes;
    }

    public String getPipeName() {
        return pipeName;
    }

    public void setPipeName(String pipeName) {
        this.pipeName = pipeName;
    }

    public List<PipesimProperty> getPropertylist() {
        return propertylist;
    }

    public void setPropertylist(List<PipesimProperty> propertylist) {
        this.propertylist = propertylist;
    }

}
