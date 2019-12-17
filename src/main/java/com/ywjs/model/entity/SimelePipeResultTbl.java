package com.ywjs.model.entity;

public class SimelePipeResultTbl extends SimelePipeResultTblKey {
    private String pipeidSimpiperes;

    private Double elevationSimpiperes;

    private Double temperatureSimpiperes;

    private Double pressureSimpiperes;

    private Double flowSimpiperes;

    private Double liquidSimpiperes;

    private Double flowrateSimpiperes;

    private Double gasheatSimpiperes;

    private Double liquidheatSimpiperes;

    private Double gasdensitySimpiperes;

    private Double liquiddensitySimpiperes;

    public SimelePipeResultTbl(Integer simulationidRealsim, String pipenameSimpiperes, Double mileageSimpiperes, String pipeidSimpiperes, Double elevationSimpiperes, Double temperatureSimpiperes, Double pressureSimpiperes, Double flowSimpiperes, Double liquidSimpiperes, Double flowrateSimpiperes, Double gasheatSimpiperes, Double liquidheatSimpiperes, Double gasdensitySimpiperes, Double liquiddensitySimpiperes) {
        super(simulationidRealsim, pipenameSimpiperes, mileageSimpiperes);
        this.pipeidSimpiperes = pipeidSimpiperes;
        this.elevationSimpiperes = elevationSimpiperes;
        this.temperatureSimpiperes = temperatureSimpiperes;
        this.pressureSimpiperes = pressureSimpiperes;
        this.flowSimpiperes = flowSimpiperes;
        this.liquidSimpiperes = liquidSimpiperes;
        this.flowrateSimpiperes = flowrateSimpiperes;
        this.gasheatSimpiperes = gasheatSimpiperes;
        this.liquidheatSimpiperes = liquidheatSimpiperes;
        this.gasdensitySimpiperes = gasdensitySimpiperes;
        this.liquiddensitySimpiperes = liquiddensitySimpiperes;
    }

    public SimelePipeResultTbl() {
        super();
    }

    public String getPipeidSimpiperes() {
        return pipeidSimpiperes;
    }

    public void setPipeidSimpiperes(String pipeidSimpiperes) {
        this.pipeidSimpiperes = pipeidSimpiperes == null ? null : pipeidSimpiperes.trim();
    }

    public Double getElevationSimpiperes() {
        return elevationSimpiperes;
    }

    public void setElevationSimpiperes(Double elevationSimpiperes) {
        this.elevationSimpiperes = elevationSimpiperes;
    }

    public Double getTemperatureSimpiperes() {
        return temperatureSimpiperes;
    }

    public void setTemperatureSimpiperes(Double temperatureSimpiperes) {
        this.temperatureSimpiperes = temperatureSimpiperes;
    }

    public Double getPressureSimpiperes() {
        return pressureSimpiperes;
    }

    public void setPressureSimpiperes(Double pressureSimpiperes) {
        this.pressureSimpiperes = pressureSimpiperes;
    }

    public Double getFlowSimpiperes() {
        return flowSimpiperes;
    }

    public void setFlowSimpiperes(Double flowSimpiperes) {
        this.flowSimpiperes = flowSimpiperes;
    }

    public Double getLiquidSimpiperes() {
        return liquidSimpiperes;
    }

    public void setLiquidSimpiperes(Double liquidSimpiperes) {
        this.liquidSimpiperes = liquidSimpiperes;
    }

    public Double getFlowrateSimpiperes() {
        return flowrateSimpiperes;
    }

    public void setFlowrateSimpiperes(Double flowrateSimpiperes) {
        this.flowrateSimpiperes = flowrateSimpiperes;
    }

    public Double getGasheatSimpiperes() {
        return gasheatSimpiperes;
    }

    public void setGasheatSimpiperes(Double gasheatSimpiperes) {
        this.gasheatSimpiperes = gasheatSimpiperes;
    }

    public Double getLiquidheatSimpiperes() {
        return liquidheatSimpiperes;
    }

    public void setLiquidheatSimpiperes(Double liquidheatSimpiperes) {
        this.liquidheatSimpiperes = liquidheatSimpiperes;
    }

    public Double getGasdensitySimpiperes() {
        return gasdensitySimpiperes;
    }

    public void setGasdensitySimpiperes(Double gasdensitySimpiperes) {
        this.gasdensitySimpiperes = gasdensitySimpiperes;
    }

    public Double getLiquiddensitySimpiperes() {
        return liquiddensitySimpiperes;
    }

    public void setLiquiddensitySimpiperes(Double liquiddensitySimpiperes) {
        this.liquiddensitySimpiperes = liquiddensitySimpiperes;
    }
}