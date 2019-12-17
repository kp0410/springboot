/** 
 * @file: IndexController.java 
 * @Package： com.ywjs.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月19日 下午4:02:17 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */
package com.ywjs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.ywjs.model.dto.*;
import com.ywjs.model.entity.RealtimesimNodeResultTbl;
import com.ywjs.pythontookit.service.PipesimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import com.ywjs.common.vo.Result;
import com.ywjs.model.entity.EarlyWarning;
import com.ywjs.service.PipeNetworkRunService;

import static java.util.Comparator.comparing;

/**
 * @ClassName PipeNetworkRunController
 * @Description TODO(管网运行Controller)
 * @Author 周伟
 * @Date 2019年11月22日 下午2:55:37
 */
@Component
@RestController
@RequestMapping("/gwyxfx")
public class PipeNetworkRunController {

    @Autowired
    PipeNetworkRunService pipeNetworkRunService;
    @Autowired
    PipesimService pipesimService;

    // 存储预报警及案例库信息
    @RequestMapping("/saveEarlyWarning")
    public Result saveEarlyWarning(@RequestBody EarlyWarning earlyWarning) {
        pipeNetworkRunService.saveEarlyWarning(earlyWarning);
        return Result.success();
    }

    // 存储预报警及案例库信息
    @RequestMapping("/getEarlyWarning")
    public Result getEarlyWarning() {
        List<EarlyWarning> listEarlyWarning = pipeNetworkRunService.getEarlyWarning();
        return Result.success(listEarlyWarning);
    }

    // deleteBatchEarlyWarning
    // 存储预报警及案例库信息
    @RequestMapping("/deleteBatchEarlyWarning")
    public Result deleteBatchEarlyWarning(Long[] ids) {
        pipeNetworkRunService.deleteBatchEarlyWarning(ids);
        return Result.success();
    }

    /**
     * 获取节点的最后十条实时节点数据
     * @return
     */
    @RequestMapping("/getnodefzjglist")
    public Object getNodeFzjgList(@RequestBody GetNodeFzjgData getNodeFzjgData) throws ParseException {
        List<RealtimesimNodeResultTbl> realtimeSimulationIdList = pipesimService.selectSimulationidEndTen();//获取仿真id的list集合
        List<ElementName> elementlist = getNodeFzjgData.getElementlist();//节点设备名称的集合
        List nodedataList = new ArrayList<>();//节点数据的集合
        for (int i = 0; i < realtimeSimulationIdList.size(); i++) {
            Integer simulationId = realtimeSimulationIdList.get(i).getSimulationidRealsimall();
            Date realtime = pipesimService.selectRealtimeById(simulationId);//获取仿真模拟表的创建时间
            //把仿真模拟表的创建时间去掉秒的显示
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String s = sdf.format(realtime);
            Date date = sdf.parse(s);
            List<NodeProperty> node = new ArrayList<>();//list集合存放节点属性值数据
            for (int j = 0; j < elementlist.size(); j++) {
                String elementname = elementlist.get(j).getElementname();
                RealtimesimNodeResultTbl nodeRealtimeData = pipesimService.selectDataByNode(simulationId, elementname);//根据实时仿真方案id和节点名称查询节点数据
                Double flow = nodeRealtimeData.getFlowRealsimnoderes();//流量
                Double pressure = nodeRealtimeData.getPressureRealsimnoderes();//压力
                Double temperature = nodeRealtimeData.getTemperatureRealsimnoderes();//温度
                String elementid = nodeRealtimeData.getElementidRealsimnoderes();//设备编号
                NodeProperty nodeProperty = new NodeProperty();
                nodeProperty.setElementidRealsimnoderes(elementid);
                nodeProperty.setElementnameRealsimnoderes(elementname);
                nodeProperty.setFlowRealsimnoderes(flow);
                nodeProperty.setPressureRealsimnoderes(pressure);
                nodeProperty.setTemperatureRealsimnoderes(temperature);
                node.add(nodeProperty);
            }
            nodedataList.add(new NodeData(date, node));
        }
        return nodedataList;
    }



}
