package com.ywjs.model.entity;

public class RealtimesimPipeResultTblKey {
    private Integer simulationidRealsimall;

    private String pipenameSimpiperes;

    private Double mileageSimpiperes;

    public RealtimesimPipeResultTblKey(Integer simulationidRealsimall, String pipenameSimpiperes, Double mileageSimpiperes) {
        this.simulationidRealsimall = simulationidRealsimall;
        this.pipenameSimpiperes = pipenameSimpiperes;
        this.mileageSimpiperes = mileageSimpiperes;
    }

    public RealtimesimPipeResultTblKey() {
        super();
    }

    public Integer getSimulationidRealsimall() {
        return simulationidRealsimall;
    }

    public void setSimulationidRealsimall(Integer simulationidRealsimall) {
        this.simulationidRealsimall = simulationidRealsimall;
    }

    public String getPipenameSimpiperes() {
        return pipenameSimpiperes;
    }

    public void setPipenameSimpiperes(String pipenameSimpiperes) {
        this.pipenameSimpiperes = pipenameSimpiperes == null ? null : pipenameSimpiperes.trim();
    }

    public Double getMileageSimpiperes() {
        return mileageSimpiperes;
    }

    public void setMileageSimpiperes(Double mileageSimpiperes) {
        this.mileageSimpiperes = mileageSimpiperes;
    }
}