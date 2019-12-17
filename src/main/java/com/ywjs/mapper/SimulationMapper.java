package com.ywjs.mapper;

import com.ywjs.model.entity.Simulation;
import com.ywjs.model.entity.SimulationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SimulationMapper {
    Simulation selectMax();

    int countByExample(SimulationExample example);

    int deleteByExample(SimulationExample example);

    int deleteByPrimaryKey(Long simulationidSim);

    int insert(Simulation record);

    int insertSelective(Simulation record);

    List<Simulation> selectByExample(SimulationExample example);

    Simulation selectByPrimaryKey(Long simulationidSim);

    int updateByExampleSelective(@Param("record") Simulation record, @Param("example") SimulationExample example);

    int updateByExample(@Param("record") Simulation record, @Param("example") SimulationExample example);

    int updateByPrimaryKeySelective(Simulation record);

    int updateByPrimaryKey(Simulation record);
}