package com.ywjs.pythontookit.controller;

import com.ywjs.common.utils.DateUtils;
import com.ywjs.model.dto.ElementName;
import com.ywjs.model.dto.NodeData;
import com.ywjs.model.dto.NodeProperty;
import com.ywjs.model.entity.RealtimesimNodeResultTbl;
import com.ywjs.pythontookit.service.PipesimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class GetRealtimeNodePipesim {

    @Autowired
    PipesimService pipesimService;

    /**
     * 获取实时节点数据
     * @param realtime
     * @return
     */
    public Object getNodeFzjg(Date realtime, List<ElementName> elementNameList){
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
        NodeData nodeData = new NodeData();
        List<NodeProperty> node =  new ArrayList<>();//list集合存放属性值
        for (int i = 0; i < elementNameList.size(); i++) {
            String elementname = elementNameList.get(i).getElementname();//节点名称
            RealtimesimNodeResultTbl nodeRealtimeData = pipesimService.selectDataByNode(simulationid,elementname);//根据实时仿真方案id和节点名称查询节点数据
            Double flow = nodeRealtimeData.getFlowRealsimnoderes();//流量
            Double pressure = nodeRealtimeData.getPressureRealsimnoderes();//压力
            Double temperature = nodeRealtimeData.getTemperatureRealsimnoderes();//温度
            String id = nodeRealtimeData.getElementidRealsimnoderes();//设备编号
            NodeProperty nodeProperty = new NodeProperty();
            nodeProperty.setElementidRealsimnoderes(id);
            nodeProperty.setElementnameRealsimnoderes(elementname);
            nodeProperty.setFlowRealsimnoderes(flow);
            nodeProperty.setPressureRealsimnoderes(pressure);
            nodeProperty.setTemperatureRealsimnoderes(temperature);
            node.add(nodeProperty);
        }
        nodeData.setRealtime(realtime);//实时时间
        nodeData.setElementlist(node);//节点数据
        return nodeData;
    }
}
