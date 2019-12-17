package com.ywjs.pythontookit.controller;

import com.ywjs.common.utils.DateUtils;
import com.ywjs.model.dto.*;
import com.ywjs.model.entity.RealtimesimPipeResultTbl;
import com.ywjs.pythontookit.service.PipesimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class GetRealtimeBranchPipesim {

    @Autowired
    PipesimService pipesimService;
    /**
     * 获取管段实时模拟结果
     * @return
     */
    public Object getPipeFzjg(Date realtime, List<PiPeidList> pipeidlist){
        String formatDate = DateUtils.formatDate(realtime, "yyyy-MM-dd HH:mm:ss");
        String realtimeStr = formatDate.substring(0, formatDate.length() - 2) + "00";
        try {
            realtime = DateUtils.parseDateTime(realtimeStr, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer simulationid = pipesimService.selectSimulationidByRealtime(realtime);//通过实时模拟的时间从实时仿真结果总表查询实时仿真模拟表ID
        while (simulationid==null)
        {
            realtime = new Date(realtime.getTime()-1000*60);
            simulationid=pipesimService.selectSimulationidByRealtime(realtime);
        }
//        if(simulationid==null)
//        {
//
//            getPipeFzjg(realtime,pipeidlist);
//        }
        BranchData branchData = new BranchData();
        //List<PiPeidList> pipeidlist = getPipeFzjg.getPipeidlist();
        BrachProperty brachProperty = null;
        List branch1 =  new ArrayList<>();//list集合存放管道信息
        for (int i = 0; i < pipeidlist.size(); i++) {
            String pipeid = pipeidlist.get(i).getPipeid();//管线编号
            String pipename = pipeidlist.get(i).getPipename();//管线名称
            List<RealtimesimPipeResultTbl> branchRealtimeData = pipesimService.selectDataByBranch(simulationid, pipeid, pipename);
            PipesimProperty pipesimProperty = null;
            brachProperty = new BrachProperty();
            brachProperty.setPipeidSimpiperes(pipeid);
            brachProperty.setPipeName(pipename);
            List branch = new ArrayList<>();//list集合存放属性值
            for (int j = 0; j < branchRealtimeData.size(); j++) {
                Double elevation = branchRealtimeData.get(j).getElevationSimpiperes();//高程
                Double flow = branchRealtimeData.get(j).getFlowSimpiperes();//流量
                Double liquid = branchRealtimeData.get(j).getLiquidSimpiperes();//持液率
                Double pressure = branchRealtimeData.get(j).getPressureSimpiperes();//压力
                Double temperature = branchRealtimeData.get(j).getTemperatureSimpiperes();//温度
                Double mileage = branchRealtimeData.get(j).getMileageSimpiperes();//里程
                pipesimProperty = new PipesimProperty();
                pipesimProperty.setElevationSimpiperes(elevation);
                pipesimProperty.setFlowSimpiperes(flow);
                pipesimProperty.setLiquidSimpiperes(liquid);
                pipesimProperty.setMileageSimpiperes(mileage);
                pipesimProperty.setPressureSimpiperes(pressure);
                pipesimProperty.setTemperatureSimpiperes(temperature);
                branch.add(pipesimProperty);
            }
            branch1.add(new BrachProperty(pipeid,pipename,branch));
        }
        branchData.setRealtime(realtime);//实时时间
        branchData.setElementlist(branch1);
        return branchData;
    }
}
