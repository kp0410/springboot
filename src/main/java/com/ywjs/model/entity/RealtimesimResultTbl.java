package com.ywjs.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RealtimesimResultTbl {
    private Long simulationidRealsimall;

    private Integer simulationidRealsim;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date realtimeSim;

    public RealtimesimResultTbl(Long simulationidRealsimall, Integer simulationidRealsim, Date realtimeSim) {
        this.simulationidRealsimall = simulationidRealsimall;
        this.simulationidRealsim = simulationidRealsim;
        this.realtimeSim = realtimeSim;
    }

    public RealtimesimResultTbl() {
        super();
    }

    public Long getSimulationidRealsimall() {
        return simulationidRealsimall;
    }

    public void setSimulationidRealsimall(Long simulationidRealsimall) {
        this.simulationidRealsimall = simulationidRealsimall;
    }

    public Integer getSimulationidRealsim() {
        return simulationidRealsim;
    }

    public void setSimulationidRealsim(Integer simulationidRealsim) {
        this.simulationidRealsim = simulationidRealsim;
    }

    public Date getRealtimeSim() {
        return realtimeSim;
    }

    public void setRealtimeSim(Date realtimeSim) {
        this.realtimeSim = realtimeSim;
    }
}