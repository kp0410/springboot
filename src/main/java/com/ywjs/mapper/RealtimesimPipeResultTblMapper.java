package com.ywjs.mapper;

import com.ywjs.model.entity.RealtimesimPipeResultTbl;
import com.ywjs.model.entity.RealtimesimPipeResultTblKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RealtimesimPipeResultTblMapper {
    int deleteByPrimaryKey(RealtimesimPipeResultTblKey key);

    int insert(RealtimesimPipeResultTbl record);

    int insertSelective(RealtimesimPipeResultTbl record);

    RealtimesimPipeResultTbl selectByPrimaryKey(RealtimesimPipeResultTblKey key);

    int updateByPrimaryKeySelective(RealtimesimPipeResultTbl record);

    int updateByPrimaryKey(RealtimesimPipeResultTbl record);

    List<RealtimesimPipeResultTbl> selectByIdName(@Param("simulationid")Integer simulationid,@Param("pipeid") String pipeid,@Param("pipename") String pipename);

    //通过id和name查出对应的参数
    Double selectMaxRealtimeByIdName(@Param("pipesimId") Integer pipesimId,@Param("name") String name);

    Double selectMinRealtimeByIdName(@Param("pipesimId") Integer pipesimId,@Param("name") String name);

    RealtimesimPipeResultTbl selectByIdNameMileage(@Param("pipesimId") Integer pipesimId,@Param("name") String name,@Param("total") Double total);


    RealtimesimPipeResultTbl selectHeatByIdName(@Param("pipesimId") Integer pipesimId,@Param("name") String name);
}