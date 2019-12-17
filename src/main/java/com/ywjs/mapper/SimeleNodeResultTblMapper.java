package com.ywjs.mapper;

import com.ywjs.model.entity.SimeleNodeResultTbl;
import com.ywjs.model.entity.SimeleNodeResultTblKey;

public interface SimeleNodeResultTblMapper {
    int deleteByPrimaryKey(SimeleNodeResultTblKey key);

    int insert(SimeleNodeResultTbl record);

    int insertSelective(SimeleNodeResultTbl record);

    SimeleNodeResultTbl selectByPrimaryKey(SimeleNodeResultTblKey key);

    int updateByPrimaryKeySelective(SimeleNodeResultTbl record);

    int updateByPrimaryKey(SimeleNodeResultTbl record);
}