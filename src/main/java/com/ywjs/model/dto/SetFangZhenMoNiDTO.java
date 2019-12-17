package com.ywjs.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;


//仿真模拟
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetFangZhenMoNiDTO implements Serializable {
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
