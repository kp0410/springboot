package com.ywjs.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class BranchData implements Serializable{

    private Date realtime;

    private List<BrachProperty> elementlist;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getRealtime() {
        return realtime;
    }

    public void setRealtime(Date realtime) {
        this.realtime = realtime;
    }

    public List<BrachProperty> getElementlist() {
        return elementlist;
    }

    public void setElementlist(List<BrachProperty> elementlist) {
        this.elementlist = elementlist;
    }
}
