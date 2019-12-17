package com.ywjs.model.dto;

/**
 * @author zhouwei
 * @create 2019-12-06 10:16
 */
public class EncGetRealTimeDataDTO {

    GetRealTimeDataDTO stationandelementlist;

    public GetRealTimeDataDTO getStationandelementlist() {
        return stationandelementlist;
    }

    public void setStationandelementlist(GetRealTimeDataDTO stationandelementlist) {
        this.stationandelementlist = stationandelementlist;
    }

    @Override
    public String toString() {
        return "EncGetRealTimeDataDTO{" +
                "stationandelementlist=" + stationandelementlist +
                '}';
    }
}
