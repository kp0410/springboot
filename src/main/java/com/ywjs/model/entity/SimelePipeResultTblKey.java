package com.ywjs.model.entity;

public class SimelePipeResultTblKey {
    private Integer simulationidRealsim;

    private String pipenameSimpiperes;

    private Double mileageSimpiperes;

    public SimelePipeResultTblKey(Integer simulationidRealsim, String pipenameSimpiperes, Double mileageSimpiperes) {
        this.simulationidRealsim = simulationidRealsim;
        this.pipenameSimpiperes = pipenameSimpiperes;
        this.mileageSimpiperes = mileageSimpiperes;
    }

    public SimelePipeResultTblKey() {
        super();
    }

    public Integer getSimulationidRealsim() {
        return simulationidRealsim;
    }

    public void setSimulationidRealsim(Integer simulationidRealsim) {
        this.simulationidRealsim = simulationidRealsim;
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