package com.ywjs.model.dto;

import java.io.Serializable;

public class NodeProperty implements Serializable {

    private String elementnameRealsimnoderes;//设备名称

    private String elementidRealsimnoderes;//设备编号

    private Double temperatureRealsimnoderes;//温度

    private Double pressureRealsimnoderes;//压力

    private Double flowRealsimnoderes;//流量

    public String getElementnameRealsimnoderes() {
        return elementnameRealsimnoderes;
    }

    public void setElementnameRealsimnoderes(String elementnameRealsimnoderes) {
        this.elementnameRealsimnoderes = elementnameRealsimnoderes;
    }

    public String getElementidRealsimnoderes() {
        return elementidRealsimnoderes;
    }

    public void setElementidRealsimnoderes(String elementidRealsimnoderes) {
        this.elementidRealsimnoderes = elementidRealsimnoderes;
    }

    public Double getTemperatureRealsimnoderes() {
        return temperatureRealsimnoderes;
    }

    public void setTemperatureRealsimnoderes(Double temperatureRealsimnoderes) {
        this.temperatureRealsimnoderes = temperatureRealsimnoderes;
    }

    public Double getPressureRealsimnoderes() {
        return pressureRealsimnoderes;
    }

    public void setPressureRealsimnoderes(Double pressureRealsimnoderes) {
        this.pressureRealsimnoderes = pressureRealsimnoderes;
    }

    public Double getFlowRealsimnoderes() {
        return flowRealsimnoderes;
    }

    public void setFlowRealsimnoderes(Double flowRealsimnoderes) {
        this.flowRealsimnoderes = flowRealsimnoderes;
    }
}
