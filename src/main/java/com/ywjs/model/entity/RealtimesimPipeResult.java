package com.ywjs.model.entity;


import java.io.Serializable;

/**
 * zhouwei
 * 各管段实时模拟结果实体
 */
public class RealtimesimPipeResult implements Serializable {
    private Long simulationidRealsimall; //实时仿真结果总表ID

    private String pipenameSimpiperes; //管段名称

    private String pipeidSimpiperes; //管段编号

    private Double mileageSimpiperes; //里程

    private Double elevationSimpiperes; //高程

    private Double temperatureSimpiperes; //温度

    private Double pressureSimpiperes; //压力

    private Double flowSimpiperes; //流量

    private Double liquidSimpiperes; //持液率

    private static final long serialVersionUID = 1L;

    public Long getSimulationidRealsimall() {
        return simulationidRealsimall;
    }

    public void setSimulationidRealsimall(Long simulationidRealsimall) {
        this.simulationidRealsimall = simulationidRealsimall;
    }

    public String getPipenameSimpiperes() {
        return pipenameSimpiperes;
    }

    public void setPipenameSimpiperes(String pipenameSimpiperes) {
        this.pipenameSimpiperes = pipenameSimpiperes == null ? null : pipenameSimpiperes.trim();
    }

    public String getPipeidSimpiperes() {
        return pipeidSimpiperes;
    }

    public void setPipeidSimpiperes(String pipeidSimpiperes) {
        this.pipeidSimpiperes = pipeidSimpiperes == null ? null : pipeidSimpiperes.trim();
    }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", simulationidRealsimall=").append(simulationidRealsimall);
        sb.append(", pipenameSimpiperes=").append(pipenameSimpiperes);
        sb.append(", pipeidSimpiperes=").append(pipeidSimpiperes);
        sb.append(", mileageSimpiperes=").append(mileageSimpiperes);
        sb.append(", elevationSimpiperes=").append(elevationSimpiperes);
        sb.append(", temperatureSimpiperes=").append(temperatureSimpiperes);
        sb.append(", pressureSimpiperes=").append(pressureSimpiperes);
        sb.append(", flowSimpiperes=").append(flowSimpiperes);
        sb.append(", liquidSimpiperes=").append(liquidSimpiperes);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}