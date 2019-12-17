/** 
 * @file: StationandeLement.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月26日 上午10:39:54 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName StationandeLement
 * @Description TODO(站场与设备列表) 
 * @Author 周伟
 * @Date 2019年11月26日 上午10:39:54
 */
public class StationandeLementVO implements Serializable{
    
    private String stationname;//站场名
    private String stationid;//站场编号
    private List<ElementVO> elementlist; //站场内设备列表

    
    public String getStationname() {
        return stationname;
    }
    
    public void setStationname(String stationname) {
        this.stationname = stationname;
    }
    
    public String getStationid() {
        return stationid;
    }
    
    public void setStationid(String stationid) {
        this.stationid = stationid;
    }
    
    public List<ElementVO> getElementlist() {
        return elementlist;
    }
    
    public void setElementlist(List<ElementVO> elementlist) {
        this.elementlist = elementlist;
    }
    


    @Override
    public String toString() {
        return "StationandeLementVO [stationname=" + stationname + ", stationid=" + stationid + ", elementlist="
                + elementlist +  "]";
    }
    
    
    
}
