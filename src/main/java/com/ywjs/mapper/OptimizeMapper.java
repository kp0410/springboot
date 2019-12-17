package com.ywjs.mapper;

import com.ywjs.model.entity.Optimize;
import com.ywjs.model.entity.OptimizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OptimizeMapper {
    int countByExample(OptimizeExample example);

    int deleteByExample(OptimizeExample example);

    int deleteByPrimaryKey(String optimidOptim);

    int insert(Optimize record);

    int insertSelective(Optimize record);

    List<Optimize> selectByExample(OptimizeExample example);

    Optimize selectByPrimaryKey(String optimidOptim);

    int updateByExampleSelective(@Param("record") Optimize record, @Param("example") OptimizeExample example);

    int updateByExample(@Param("record") Optimize record, @Param("example") OptimizeExample example);

    int updateByPrimaryKeySelective(Optimize record);

    int updateByPrimaryKey(Optimize record);
}