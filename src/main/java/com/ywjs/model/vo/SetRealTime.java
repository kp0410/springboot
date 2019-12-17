package com.ywjs.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ywjs.model.dto.ElementPropertyDTO;
import com.ywjs.model.dto.SimSettingDTO;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class SetRealTime implements Serializable{


    private Integer realtimeSimid;//实时仿真模拟方案id

    private List<ElementPropertyDTO> elementpropertylist;//实时仿真设置参数

    private List<SimSettingDTO> simsettinglist;//实时全局设置参数集合

    public Integer getRealtimeSimid() {
        return realtimeSimid;
    }

    public void setRealtimeSimid(Integer realtimeSimid) {
        this.realtimeSimid = realtimeSimid;
    }

    public List<ElementPropertyDTO> getElementpropertylist() {
        return elementpropertylist;
    }

    public void setElementpropertylist(List<ElementPropertyDTO> elementpropertylist) {
        this.elementpropertylist = elementpropertylist;
    }

    public List<SimSettingDTO> getSimsettinglist() {
        return simsettinglist;
    }

    public void setSimsettinglist(List<SimSettingDTO> simsettinglist) {
        this.simsettinglist = simsettinglist;
    }
}
