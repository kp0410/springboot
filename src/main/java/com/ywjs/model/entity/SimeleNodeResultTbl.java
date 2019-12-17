package com.ywjs.model.entity;

public class SimeleNodeResultTbl extends SimeleNodeResultTblKey {
    private String elementnameSimnoderes;

    private Double temperatureSimnoderes;

    private Double pressureSimpiperes;

    private Double flowRealsimnoderes;

    public SimeleNodeResultTbl(Integer simulationidSim, String elementidSimnoderes, String elementnameSimnoderes, Double temperatureSimnoderes, Double pressureSimpiperes, Double flowRealsimnoderes) {
        super(simulationidSim, elementidSimnoderes);
        this.elementnameSimnoderes = elementnameSimnoderes;
        this.temperatureSimnoderes = temperatureSimnoderes;
        this.pressureSimpiperes = pressureSimpiperes;
        this.flowRealsimnoderes = flowRealsimnoderes;
    }

    public SimeleNodeResultTbl() {
        super();
    }

    public String getElementnameSimnoderes() {
        return elementnameSimnoderes;
    }

    public void setElementnameSimnoderes(String elementnameSimnoderes) {
        this.elementnameSimnoderes = elementnameSimnoderes == null ? null : elementnameSimnoderes.trim();
    }

    public Double getTemperatureSimnoderes() {
        return temperatureSimnoderes;
    }

    public void setTemperatureSimnoderes(Double temperatureSimnoderes) {
        this.temperatureSimnoderes = temperatureSimnoderes;
    }

    public Double getPressureSimpiperes() {
        return pressureSimpiperes;
    }

    public void setPressureSimpiperes(Double pressureSimpiperes) {
        this.pressureSimpiperes = pressureSimpiperes;
    }

    public Double getFlowRealsimnoderes() {
        return flowRealsimnoderes;
    }

    public void setFlowRealsimnoderes(Double flowRealsimnoderes) {
        this.flowRealsimnoderes = flowRealsimnoderes;
    }
}