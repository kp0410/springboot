package com.ywjs.model.dto;

import java.io.Serializable;
import java.util.List;

//仿真模拟

public class SetShiShiMoNiDTO implements Serializable {
    private Integer simulationidSim;
    private List<SimSettingDTO> simsettinglist;
    private List<ElementPropertyDTO> elementpropertylist;

    public Integer getSimulationidSim() {
        return simulationidSim;
    }

    public void setSimulationidSim(Integer simulationidSim) {
        this.simulationidSim = simulationidSim;
    }

    public List<SimSettingDTO> getSimsettinglist() {
        return simsettinglist;
    }

    public void setSimsettinglist(List<SimSettingDTO> simsettinglist) {
        this.simsettinglist = simsettinglist;
    }

    public List<ElementPropertyDTO> getElementpropertylist() {
        return elementpropertylist;
    }

    public void setElementpropertylist(List<ElementPropertyDTO> elementpropertylist) {
        this.elementpropertylist = elementpropertylist;
    }
}