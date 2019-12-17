package com.ywjs.model.dto;

import java.io.Serializable;
import java.util.List;

public class GetNodeFzjg implements Serializable{
    private List<ElementName> elementlist;

    private List<NodeData> data;

    public List<ElementName> getElementlist() {
        return elementlist;
    }

    public void setElementlist(List<ElementName> elementlist) {
        this.elementlist = elementlist;
    }

    public List<NodeData> getData() {
        return data;
    }

    public void setData(List<NodeData> data) {
        this.data = data;
    }
}
