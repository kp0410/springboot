package com.ywjs.mapper;

import com.ywjs.model.entity.RealtimesimNodeResultTbl;
import com.ywjs.model.entity.RealtimesimNodeResultTblKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RealtimesimNodeResultTblMapper {

    int deleteAll();

    int deleteByPrimaryKey(RealtimesimNodeResultTblKey key);

    int insert(RealtimesimNodeResultTbl record);

    int insertSelective(RealtimesimNodeResultTbl record);

    RealtimesimNodeResultTbl selectByPrimaryKey(RealtimesimNodeResultTblKey key);

    int updateByPrimaryKeySelective(RealtimesimNodeResultTbl record);

    int updateByPrimaryKey(RealtimesimNodeResultTbl record);


    RealtimesimNodeResultTbl selectByName(@Param("simulationid") Integer simulationid,@Param("elementname") String elementname);

    List<RealtimesimNodeResultTbl> selectSimulationidEndTen();
}