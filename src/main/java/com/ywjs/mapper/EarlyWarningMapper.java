package com.ywjs.mapper;

import com.ywjs.model.entity.EarlyWarning;
import com.ywjs.model.entity.EarlyWarningExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EarlyWarningMapper {
    int countByExample(EarlyWarningExample example);

    int deleteByExample(EarlyWarningExample example);

    int deleteByPrimaryKey(Long earwaridEarwar);

    int insert(EarlyWarning record);

    int insertSelective(EarlyWarning record);

    List<EarlyWarning> selectByExample(EarlyWarningExample example);

    EarlyWarning selectByPrimaryKey(Long earwaridEarwar);

    int updateByExampleSelective(@Param("record") EarlyWarning record, @Param("example") EarlyWarningExample example);

    int updateByExample(@Param("record") EarlyWarning record, @Param("example") EarlyWarningExample example);

    int updateByPrimaryKeySelective(EarlyWarning record);

    int updateByPrimaryKey(EarlyWarning record);
}