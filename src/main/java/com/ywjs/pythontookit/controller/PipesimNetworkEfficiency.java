package com.ywjs.pythontookit.controller;

import com.ywjs.common.vo.Result;
import com.ywjs.model.entity.RealtimesimPipeResultTbl;
import com.ywjs.pythontookit.pipesimutil.PipesimeNetworkEfficiencyUtil;
import com.ywjs.pythontookit.service.PipesimService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 管网效率计算
 */
public class PipesimNetworkEfficiency {

    @Autowired
    PipesimService pipesimService;

    /**
     * 管路效率计算
     * @param firstName  第一条管线的名称
     * @param lastName   最后一条管线的名称
     * @return
     */
    public Double pipesimLineEfficiency(Integer pipesimId,String firstName,String lastName){
        Double firstTotal = pipesimService.selectMaxRealtimeByIdName(pipesimId,firstName);//查出对应的管线里程最大值
        Double lastTotal = pipesimService.selectMaxRealtimeByIdName(pipesimId,lastName);//查出对应的管线里程最大值
        if (firstTotal > lastTotal){
            Double minTotal = pipesimService.selectMinRealtimeByIdName(pipesimId,lastName);//查出对应的管线里程最小值
            RealtimesimPipeResultTbl realtimePipeOut = pipesimService.selectByIdNameMileage(pipesimId,firstName,firstTotal);//出口
            RealtimesimPipeResultTbl realtimePipeIn = pipesimService.selectByIdNameMileage(pipesimId,lastName,minTotal);//进口
            Double efficency = pipesimService.lineEfficiency(realtimePipeOut,realtimePipeIn);
            return efficency;
        }
        Double minTotal = pipesimService.selectMinRealtimeByIdName(pipesimId,firstName);//查出对应的管线里程最小值
        RealtimesimPipeResultTbl realtimePipeOut = pipesimService.selectByIdNameMileage(pipesimId,lastName,lastTotal);//出口
        RealtimesimPipeResultTbl realtimePipeIn = pipesimService.selectByIdNameMileage(pipesimId,firstName,minTotal);//进口
        Double efficency = pipesimService.lineEfficiency(realtimePipeOut,realtimePipeIn);
        return efficency;
    }

    /**
     * 加热炉效率
     * @return
     */
    public Double pipesimHeatingEfficiency(Integer pipesimId,String heatName){
        //TODO 加热炉总能量
        Double gasHeatValue = 0.0;
        Double gasConsumption = 0.0;
        Double heater = PipesimeNetworkEfficiencyUtil.heaterEnergy(gasHeatValue, gasConsumption);

        //有效能量
        Double heatTotal = pipesimService.selectMaxRealtimeByIdName(pipesimId, heatName);//加热炉的里程
        pipesimService.selectByIdTotal(pipesimId,heatTotal);



        return null;
    }


}
