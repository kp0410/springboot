package com.ywjs.model.entity;

public class RealtimesimNodeResultTblKey {
    private Integer simulationidRealsimall;

    private String elementnameRealsimnoderes;

    public RealtimesimNodeResultTblKey(Integer simulationidRealsimall, String elementnameRealsimnoderes) {
        this.simulationidRealsimall = simulationidRealsimall;
        this.elementnameRealsimnoderes = elementnameRealsimnoderes;
    }

    public RealtimesimNodeResultTblKey() {
        super();
    }

    public Integer getSimulationidRealsimall() {
        return simulationidRealsimall;
    }

    public void setSimulationidRealsimall(Integer simulationidRealsimall) {
        this.simulationidRealsimall = simulationidRealsimall;
    }

    public String getElementnameRealsimnoderes() {
        return elementnameRealsimnoderes;
    }

    public void setElementnameRealsimnoderes(String elementnameRealsimnoderes) {
        this.elementnameRealsimnoderes = elementnameRealsimnoderes == null ? null : elementnameRealsimnoderes.trim();
    }
}