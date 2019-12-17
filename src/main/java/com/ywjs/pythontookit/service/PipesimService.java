package com.ywjs.pythontookit.service;

import com.ywjs.common.vo.Result;
import com.ywjs.model.entity.*;

import java.util.Date;
import java.util.List;

public interface PipesimService {

    /**
     * 打开
     * @param file
     * @return
     */
    String open(String file);

    String update(String[][] updateData);

    String setSimSetting(String[][] equation);

    String resultBranch();

    String save(String filePath);

    String resultNode();

    String getSimSetting();

    String close();

    String insertbranch(SimelePipeResultTbl simelePipeResultTbl);

    String insertnode(SimeleNodeResultTbl simeleNodeResultTbl);

    Integer insertShiShiMoNi(RealtimesimResultTbl realtimesimResultTbl);

    void insertRealtimeNode(RealtimesimNodeResultTbl realtimesimNodeResultTbl);

    void insertRealtimeBranch(RealtimesimPipeResultTbl realtimesimPipeResultTbl);

    Integer selectSimulationidByRealtime(Date realtime);

    List<RealtimesimPipeResultTbl> selectDataByBranch(Integer simulationid, String pipeid, String pipename);

    String setGlobalFlow(String[][] flow);

    String setGlobalHeat(String[][] heat);

    RealtimesimNodeResultTbl selectDataByNode(Integer simulationid, String elementname);

    List<RealtimesimNodeResultTbl> selectSimulationidEndTen();

    Date selectRealtimeById(Integer simulationId);

    Double selectMaxRealtimeByIdName(Integer pipesimId, String name);

    Double selectMinRealtimeByIdName(Integer pipesimId, String name);

    RealtimesimPipeResultTbl selectByIdNameMileage(Integer pipesimId, String name, Double total);

    Double lineEfficiency(RealtimesimPipeResultTbl realtimePipeOut, RealtimesimPipeResultTbl realtimePipeIn);

    RealtimesimPipeResultTbl selectByIdName(Integer pipesimId, String name);
}

