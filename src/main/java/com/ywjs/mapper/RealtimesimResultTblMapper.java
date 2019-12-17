package com.ywjs.mapper;

import com.ywjs.model.entity.RealtimesimResultTbl;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface RealtimesimResultTblMapper {
    int insert(RealtimesimResultTbl record);

    int insertSelective(RealtimesimResultTbl record);

    Integer selectByRealtime(Date realtime);

    Date selectRealtimeById(@Param("simulationId") Integer simulationId);
//    Integer selectByRealtime(String realtime);
}