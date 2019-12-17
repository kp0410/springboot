package com.ywjs.model.entity;

public class SimeleNodeResultTblKey {
    private Integer simulationidSim;

    private String elementidSimnoderes;

    public SimeleNodeResultTblKey(Integer simulationidSim, String elementidSimnoderes) {
        this.simulationidSim = simulationidSim;
        this.elementidSimnoderes = elementidSimnoderes;
    }

    public SimeleNodeResultTblKey() {
        super();
    }

    public Integer getSimulationidSim() {
        return simulationidSim;
    }

    public void setSimulationidSim(Integer simulationidSim) {
        this.simulationidSim = simulationidSim;
    }

    public String getElementidSimnoderes() {
        return elementidSimnoderes;
    }

    public void setElementidSimnoderes(String elementidSimnoderes) {
        this.elementidSimnoderes = elementidSimnoderes == null ? null : elementidSimnoderes.trim();
    }
}