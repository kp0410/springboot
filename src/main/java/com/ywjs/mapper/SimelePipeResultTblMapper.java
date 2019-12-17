package com.ywjs.mapper;

import com.ywjs.model.entity.SimelePipeResultTbl;
import com.ywjs.model.entity.SimelePipeResultTblKey;

public interface SimelePipeResultTblMapper {
    int deleteByPrimaryKey(SimelePipeResultTblKey key);

    int insert(SimelePipeResultTbl record);

    int insertSelective(SimelePipeResultTbl record);

    SimelePipeResultTbl selectByPrimaryKey(SimelePipeResultTblKey key);

    int updateByPrimaryKeySelective(SimelePipeResultTbl record);

    int updateByPrimaryKey(SimelePipeResultTbl record);
}