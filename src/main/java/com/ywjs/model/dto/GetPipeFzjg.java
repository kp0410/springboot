package com.ywjs.model.dto;

import java.io.Serializable;
import java.util.List;

public class GetPipeFzjg implements Serializable{

    private List<PiPeidList> pipeidlist;

    private List<BranchData> data;

    public List<PiPeidList> getPipeidlist() {
        return pipeidlist;
    }

    public void setPipeidlist(List<PiPeidList> pipeidlist) {
        this.pipeidlist = pipeidlist;
    }

    public List<BranchData> getData() {
        return data;
    }

    public void setData(List<BranchData> data) {
        this.data = data;
    }

}
