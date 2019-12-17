package com.ywjs.model.entity;

public class RealtimesimNodeResultTbl extends RealtimesimNodeResultTblKey {
    private String elementidRealsimnoderes;

    private Double temperatureRealsimnoderes;

    private Double pressureRealsimnoderes;

    private Double flowRealsimnoderes;

    public RealtimesimNodeResultTbl(Integer simulationidRealsimall, String elementnameRealsimnoderes, String elementidRealsimnoderes, Double temperatureRealsimnoderes, Double pressureRealsimnoderes, Double flowRealsimnoderes) {
        super(simulationidRealsimall, elementnameRealsimnoderes);
        this.elementidRealsimnoderes = elementidRealsimnoderes;
        this.temperatureRealsimnoderes = temperatureRealsimnoderes;
        this.pressureRealsimnoderes = pressureRealsimnoderes;
        this.flowRealsimnoderes = flowRealsimnoderes;
    }

    public RealtimesimNodeResultTbl() {
        super();
    }

    public String getElementidRealsimnoderes() {
        return elementidRealsimnoderes;
    }

    public void setElementidRealsimnoderes(String elementidRealsimnoderes) {
        this.elementidRealsimnoderes = elementidRealsimnoderes == null ? null : elementidRealsimnoderes.trim();
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