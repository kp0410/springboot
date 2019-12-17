package com.ywjs.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class GetNodeFzjgData implements Serializable{

    private Date realtime;

    private List<ElementName> elementlist;


    public Date getRealtime() {
        return realtime;
    }

    public void setRealtime(Date realtime) {
        this.realtime = realtime;
    }

    public List<ElementName> getElementlist() {
        return elementlist;
    }

    public void setElementlist(List<ElementName> elementlist) {
        this.elementlist = elementlist;
    }


}
