package com.ywjs.mapper;

import com.ywjs.model.entity.RealtimesimPipeResult;
import com.ywjs.model.entity.RealtimesimPipeResultExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RealtimesimPipeResultMapper {
    List<RealtimesimPipeResult> selectByCondition(@Param("simulationid") Long simulationidRealsim,
                                                  @Param("realtimedata") String realtimedataSim,
                                                  @Param("name")String name);

    int countByExample(RealtimesimPipeResultExample example);

    int deleteByExample(RealtimesimPipeResultExample example);

    int insert(RealtimesimPipeResult record);

    int insertSelective(RealtimesimPipeResult record);

    List<RealtimesimPipeResult> selectByExample(RealtimesimPipeResultExample example);

    int updateByExampleSelective(@Param("record") RealtimesimPipeResult record, @Param("example") RealtimesimPipeResultExample example);

    int updateByExample(@Param("record") RealtimesimPipeResult record, @Param("example") RealtimesimPipeResultExample example);


}