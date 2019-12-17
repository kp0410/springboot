package com.ywjs.mapper;

import com.ywjs.model.entity.RealtimeSimulation;
import com.ywjs.model.entity.RealtimeSimulationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @ClassName RealtimeSimulationMapper
 * @Description TODO(实时仿真模拟mapper接口) 
 * @Author 周伟
 * @Date 2019年12月3日 上午11:31:42
 */
public interface RealtimeSimulationMapper {
    RealtimeSimulation selectMax();

    int countByExample(RealtimeSimulationExample example);

    int deleteByExample(RealtimeSimulationExample example);

    int insert(RealtimeSimulation record);

    int insertSelective(RealtimeSimulation record);

    List<RealtimeSimulation> selectByExample(RealtimeSimulationExample example);

    int updateByExampleSelective(@Param("record") RealtimeSimulation record, @Param("example") RealtimeSimulationExample example);

    int updateByExample(@Param("record") RealtimeSimulation record, @Param("example") RealtimeSimulationExample example);
}