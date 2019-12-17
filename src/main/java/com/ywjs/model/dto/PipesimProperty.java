package com.ywjs.model.dto;

import java.io.Serializable;

public class PipesimProperty implements Serializable{

    private Double mileageSimpiperes;

    private Double elevationSimpiperes;

    private Double temperatureSimpiperes;

    private Double pressureSimpiperes;

    private Double flowSimpiperes;

    private Double liquidSimpiperes;

    public Double getMileageSimpiperes() {
        return mileageSimpiperes;
    }

    public void setMileageSimpiperes(Double mileageSimpiperes) {
        this.mileageSimpiperes = mileageSimpiperes;
    }

    public Double getElevationSimpiperes() {
        return elevationSimpiperes;
    }

    public void setElevationSimpiperes(Double elevationSimpiperes) {
        this.elevationSimpiperes = elevationSimpiperes;
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

    public Double getTemperatureSimpiperes() {
        return temperatureSimpiperes;
    }

    public void setTemperatureSimpiperes(Double temperatureSimpiperes) {
        this.temperatureSimpiperes = temperatureSimpiperes;
    }

}
