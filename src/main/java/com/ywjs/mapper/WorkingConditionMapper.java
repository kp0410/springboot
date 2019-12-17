package com.ywjs.mapper;

import com.ywjs.model.entity.WorkingCondition;
import com.ywjs.model.entity.WorkingConditionExample;
import com.ywjs.model.vo.WorkVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkingConditionMapper {

    List<WorkVO> selectAllToWorkVO();
    int countByExample(WorkingConditionExample example);

    int deleteByExample(WorkingConditionExample example);

    int deleteByPrimaryKey(Integer workidWork);

    int insert(WorkingCondition record);

    int insertSelective(WorkingCondition record);

    List<WorkingCondition> selectByExample(WorkingConditionExample example);

    WorkingCondition selectByPrimaryKey(Integer workidWork);

    int updateByExampleSelective(@Param("record") WorkingCondition record, @Param("example") WorkingConditionExample example);

    int updateByExample(@Param("record") WorkingCondition record, @Param("example") WorkingConditionExample example);

    int updateByPrimaryKeySelective(WorkingCondition record);

    int updateByPrimaryKey(WorkingCondition record);
}