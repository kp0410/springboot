package com.ywjs.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class NodeData implements Serializable {
    private Date realtime;

    private List<NodeProperty> elementlist;



    public NodeData(Date realtime, List<NodeProperty> elementlist) {
        this.realtime = realtime;
        this.elementlist = elementlist;
    }

    public NodeData() { }

    public Date getRealtime() {
        return realtime;
    }

    public void setRealtime(Date realtime) {
        this.realtime = realtime;
    }

    public List<NodeProperty> getElementlist() {
        return elementlist;
    }

    public void setElementlist(List<NodeProperty> elementlist) {
        this.elementlist = elementlist;
    }
}
