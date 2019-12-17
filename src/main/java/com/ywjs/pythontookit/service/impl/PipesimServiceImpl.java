package com.ywjs.pythontookit.service.impl;

import com.ywjs.common.vo.Result;
import com.ywjs.mapper.*;
import com.ywjs.model.entity.*;
import com.ywjs.pythontookit.pipesimutil.PipesimUtil;
import com.ywjs.pythontookit.pipesimutil.PipesimeNetworkEfficiencyUtil;
import com.ywjs.pythontookit.service.PipesimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PipesimServiceImpl implements PipesimService {

    @Autowired
    SimeleNodeResultTblMapper simeleNodeResultTblMapper;
    @Autowired
    SimelePipeResultTblMapper simelePipeResultTblMapper;

    @Autowired
    RealtimesimResultTblMapper realtimesimResultTblMapper;
    @Autowired
    RealtimesimNodeResultTblMapper realtimesimNodeResultTblMapper;
    @Autowired
    RealtimesimPipeResultTblMapper realtimesimPipeResultTblMapper;


    /**
     * 打开操作
     * @param filePath
     * @return
     */
    @Override
    public String open(String filePath) {
        String open = PipesimUtil.open(filePath);
        return open;
    }

    /**
     * 更新操作
     * @param updateData
     * @return
     */
    @Override
    public String update(String[][] updateData) {
        String[] componentName = new String[updateData.length];
        String[] paramenterName = new String[updateData.length];
        String[] paramentValue = new String[updateData.length];
        for (int i = 0; i < updateData.length; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0:
                        componentName[i] = updateData[i][j];
                        break;
                    case 1:
                        paramenterName[i] = updateData[i][j];
                        break;
                    case 2:
                        paramentValue[i] = updateData[i][j];
                        break;
                }
            }
        }
        String update = PipesimUtil.batchUpdate(componentName,paramenterName,paramentValue);
        return update;
    }

    /**
     * 全局模型设置
     * @param equation
     * @return
     */
    @Override
    public String setSimSetting(String[][] equation) {
        String[] equationName = new String[equation.length];
        String[] equationValue = new String[equation.length];
        for (int i = 0; i < equation.length; i++) {
            for (int j = 0; j < 2; j++) {
                switch (j) {
                    case 0:
                        equationName[i] = equation[i][j];
                        break;
                    case 1:
                        equationValue[i] = equation[i][j];
                        break;
                }
            }
        }
        String simulation = PipesimUtil.setSimSetting(equationName, equationValue);
        return simulation;
    }

    /**
     * 返回管道数据
     * @return
     */
    @Override
    public String resultBranch() {
        String resultBranch = PipesimUtil.resultBranch();
        return resultBranch;
    }

    /**
     * 保存
     * @param filePath
     * @return
     */
    @Override
    public String save(String filePath) {
        String save = PipesimUtil.save(filePath);
        return save;
    }

    /**
     * 返回节点数据
     * @return
     */
    @Override
    public String resultNode() {
        String resultNode = PipesimUtil.resultNode();
        return resultNode;
    }

    /**
     * 全局设置
     * @return
     */
    @Override
    public String getSimSetting() {
        String simData = PipesimUtil.getSimSetting();
        return simData;
    }

    /**
     * 关闭
     * @return
     */
    @Override
    public String close() {
        String close = PipesimUtil.close();
        return close;
    }


    @Override
    public String insertbranch(SimelePipeResultTbl simelePipeResultTbl) {
        simelePipeResultTblMapper.insert(simelePipeResultTbl);
        return null;
    }

    @Override
    public String insertnode(SimeleNodeResultTbl simeleNodeResultTbl) {
        simeleNodeResultTblMapper.insert(simeleNodeResultTbl);
        return null;
    }



    @Override
    public Integer insertShiShiMoNi(RealtimesimResultTbl realtimesimResultTbl) {
        int insert = realtimesimResultTblMapper.insert(realtimesimResultTbl);
        return insert;
    }

    @Override
    public void insertRealtimeNode(RealtimesimNodeResultTbl realtimesimNodeResultTbl) {
        realtimesimNodeResultTblMapper.insert(realtimesimNodeResultTbl);
    }

    @Override
    public void insertRealtimeBranch(RealtimesimPipeResultTbl realtimesimPipeResultTbl) {
        realtimesimPipeResultTblMapper.insert(realtimesimPipeResultTbl);
    }

    @Override
    public Integer selectSimulationidByRealtime(Date realtime) {
        Integer simulationid = realtimesimResultTblMapper.selectByRealtime(realtime);
        return simulationid;
    }



    @Override
    public List<RealtimesimPipeResultTbl> selectDataByBranch(Integer simulationid, String pipeid, String pipename) {
        List<RealtimesimPipeResultTbl> pipesimPipeProperties = realtimesimPipeResultTblMapper.selectByIdName(simulationid, pipeid, pipename);
        return pipesimPipeProperties;
    }

    @Override
    public String setGlobalFlow(String[][] flow) {
        String[] equationName = new String[flow.length];
        String[] equationValue = new String[flow.length];
        for (int i = 0; i < flow.length; i++) {
            for (int j = 0; j < 2; j++) {
                switch (j) {
                    case 0:
                        equationName[i] = flow[i][j];
                        break;
                    case 1:
                        equationValue[i] = flow[i][j];
                        break;
                }
            }
        }
        String globalFlowCorrelation = PipesimUtil.setGlobalFlowCorrelation(equationName, equationValue);
        return globalFlowCorrelation;
    }


    @Override
    public String setGlobalHeat(String[][] heat) {
        String[] equationName = new String[heat.length];
        String[] equationValue = new String[heat.length];
        for (int i = 0; i < heat.length; i++) {
            for (int j = 0; j < 2; j++) {
                switch (j) {
                    case 0:
                        equationName[i] = heat[i][j];
                        break;
                    case 1:
                        equationValue[i] = heat[i][j];
                        break;
                }
            }
        }
        String globalHeatTransfer = PipesimUtil.setGlobalHeatTransfer(equationName, equationValue);
        return globalHeatTransfer;
    }

    @Override
    public RealtimesimNodeResultTbl selectDataByNode(Integer simulationid, String elementname) {
        RealtimesimNodeResultTbl realtimesimNodeResultTbl = realtimesimNodeResultTblMapper.selectByName(simulationid, elementname);
        return realtimesimNodeResultTbl;
    }

    @Override
    public List<RealtimesimNodeResultTbl> selectSimulationidEndTen() {
        List<RealtimesimNodeResultTbl> realtimesimNodeResultTblList = realtimesimNodeResultTblMapper.selectSimulationidEndTen();
        return realtimesimNodeResultTblList;
    }

    @Override
    public Date selectRealtimeById(Integer simulationId) {
        Date realtime = realtimesimResultTblMapper.selectRealtimeById(simulationId);
        return realtime;
    }

    @Override
    public Double selectMaxRealtimeByIdName(Integer pipesimId, String name) {
        Double total = realtimesimPipeResultTblMapper.selectMaxRealtimeByIdName(pipesimId,name);
        return total;
    }

    @Override
    public Double selectMinRealtimeByIdName(Integer pipesimId, String name) {
        Double total = realtimesimPipeResultTblMapper.selectMinRealtimeByIdName(pipesimId,name);
        return total;
    }

    @Override
    public RealtimesimPipeResultTbl selectByIdNameMileage(Integer pipesimId, String name, Double total) {
        RealtimesimPipeResultTbl realtimesimPipeResultTbl = realtimesimPipeResultTblMapper.selectByIdNameMileage(pipesimId,name,total);
        return realtimesimPipeResultTbl;
    }

    /**
     * 管路效率计算
     * @param realtimePipeOut 出口对象
     * @param realtimePipeIn 进口对象
     * @return
     */
    @Override
    public Double lineEfficiency(RealtimesimPipeResultTbl realtimePipeOut, RealtimesimPipeResultTbl realtimePipeIn) {
        Double outElevation = realtimePipeOut.getElevationSimpiperes();
        Double outTemperature = realtimePipeOut.getTemperatureSimpiperes();
        Double outLiquidheat = realtimePipeOut.getLiquidheatSimpiperes();
        Double outLiquiddensity = realtimePipeOut.getLiquiddensitySimpiperes();
        Double outPressure = realtimePipeOut.getPressureSimpiperes();
        Double inElevation = realtimePipeIn.getElevationSimpiperes();
        Double inTemperature = realtimePipeIn.getTemperatureSimpiperes();
        Double inLiquidheat = realtimePipeIn.getLiquidheatSimpiperes();
        Double inLiquiddensity = realtimePipeIn.getLiquiddensitySimpiperes();
        Double inPressure = realtimePipeIn.getPressureSimpiperes();
        Double lineOut = PipesimeNetworkEfficiencyUtil.lineOut(outElevation, outPressure, outLiquiddensity, outLiquidheat, outTemperature);
        Double lineIn = PipesimeNetworkEfficiencyUtil.lineIn(inElevation, inPressure, inLiquiddensity, inLiquidheat, inTemperature);
        return lineOut/lineIn;
    }

    @Override
    public RealtimesimPipeResultTbl selectByIdName(Integer pipesimId, String name) {
        RealtimesimPipeResultTbl realtimesimPipeResultTbl = realtimesimPipeResultTblMapper.selectHeatByIdName(pipesimId,name);
        return realtimesimPipeResultTbl;
    }

}
