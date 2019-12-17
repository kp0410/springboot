package com.ywjs.job;

import cn.hutool.core.collection.CollectionUtil;
import com.ywjs.common.utils.DateUtils;
import com.ywjs.mapper.PropertyValueMapper;
import com.ywjs.mapper.RealtimesimPipeResultMapper;
import com.ywjs.model.entity.*;
import com.ywjs.websocket.WebSocketService;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 模拟结果分析job
 *
 * @author zhouwei
 * @create 2019-12-11 15:48
 */
public class SimulationResultAnalysisJob implements Runnable {

    RealtimeSimulation realtimeSimulation;
    List<Element> listElement;
    PropertyValueMapper propertyValueMapper;
    RealtimesimPipeResultMapper realtimesimPipeResultMapper;

    public SimulationResultAnalysisJob(RealtimeSimulation realtimeSimulation, List<Element> listElement,
                                       PropertyValueMapper propertyValueMapper,
                                       RealtimesimPipeResultMapper realtimesimPipeResultMapper) {
        this.realtimeSimulation = realtimeSimulation;
        this.listElement = listElement;
        this.propertyValueMapper = propertyValueMapper;
        this.realtimesimPipeResultMapper = realtimesimPipeResultMapper;
    }

    @Override
    public void run() {
        // 获取当前系统时间前5分钟的时间字符串
        long time = 1000 * 60 * 5;
        Date date = new Date(System.currentTimeMillis() - time);
        String formatDate = DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss");
        String realtimedataSim = formatDate.substring(0, formatDate.length() - 2) + "00";

        // 2.2 查询属性为名称（属性id为0）对应的属性值 （查询条件属性id+工况id+元件编号）
        // 获取传入参数中的工况id
        Long workid = realtimeSimulation.getWorkidWork();
        String name = null; // 名称
        String pipemName = null; // 真实名称
        String allowableStress = null; // 许用压力
        String designPressure = null; // 设定压力
        String innerDiameter = null; // 内径
        for (Element element : listElement) {
            String elementrealnameEle = element.getElementrealnameEle(); // 元件编号
            // 属性id为0，获取名称，该条件能唯一确定一条数据，获取list中的第一条就行
            List<PropertyValue> elementNameList = propertyValueMapper.selectByExample(conditin(elementrealnameEle, workid, 0));
            if (!CollectionUtil.isEmpty(elementNameList)) {
                name = elementNameList.get(0).getProvalueProval();
            }
            // 属性id为51，获取真实名称
            List<PropertyValue> elementRealNameList = propertyValueMapper.selectByExample(conditin(elementrealnameEle, workid, 51));
            if (CollectionUtil.isEmpty(elementRealNameList)) {
                pipemName = elementRealNameList.get(0).getProvalueProval();
            }

            // 属性id为54，获取许用压力
            List<PropertyValue> allowableStressList = propertyValueMapper.selectByExample(conditin(elementrealnameEle, workid, 54));
            if (!CollectionUtil.isEmpty(allowableStressList)) {
                allowableStress = allowableStressList.get(0).getProvalueProval();
            }

            // 属性id为53，获取设定压力
            List<PropertyValue> designPressureList = propertyValueMapper.selectByExample(conditin(elementrealnameEle, workid, 53));
            if (!CollectionUtil.isEmpty(designPressureList)) {
                designPressure = designPressureList.get(0).getProvalueProval();
            }

            // 属性id为22，获取内径
            List<PropertyValue> innerDiameterList = propertyValueMapper.selectByExample(conditin(elementrealnameEle, workid, 22));
            if (!CollectionUtil.isEmpty(innerDiameterList)) {
                innerDiameter = innerDiameterList.get(0).getProvalueProval();
            }

            // 联合查询 根据模拟表id和时间获取  以及名称
            List<RealtimesimPipeResult> realtimesimPipeResults = realtimesimPipeResults = realtimesimPipeResultMapper.selectByCondition(realtimeSimulation.getSimulationidRealsim(), realtimedataSim, name);
            if(!CollectionUtil.isEmpty(realtimesimPipeResults)){
                for (RealtimesimPipeResult realtimesimPipeResult : realtimesimPipeResults) {
                    // 组织返回数据：名称+里程+压力 + 许用压力  +  设定压力 +警报提示
                    StringBuffer sb = new StringBuffer();
                    sb.append("管道名称:" + name + "\r\n").append("里程:" + realtimesimPipeResult.getMileageSimpiperes() + "\r\n")
                            .append("压力：" + realtimesimPipeResult.getPressureSimpiperes() + "\r\n");
                    if (StringUtils.isEmpty(allowableStress)) {
                        sb.append("许用压力：" + allowableStress + "\r\n");
                    } else if (StringUtils.isEmpty(designPressure)) {
                        sb.append("设定压力：" + designPressure + "\r\n");
                    }
                    sb.append("设警报级别：");

                    // 获取压力
                    Double pressureSimpiperes = realtimesimPipeResult.getPressureSimpiperes();


                    // 判断许用压力 和 设定压力 三种情况（1：都为null(不返回)；2：其中一个为null；3：都不为null）
                    // 许用压力不为null，设定压力为null
                    if (!StringUtils.isEmpty(allowableStress) && StringUtils.isEmpty(designPressure)) {
                        if (pressureSimpiperes > Double.parseDouble(allowableStress)) {
                            // 超过许用压力一级警报
                            sb.append("一级警报,当前压力大于许用值");
                            massSendMsg(sb.toString());
                        }
                    }
                    // 许用压力为null，设定压力不为null
                    if (StringUtils.isEmpty(allowableStress) && !StringUtils.isEmpty(designPressure)) {
                        if (pressureSimpiperes < Double.parseDouble(designPressure)) {
                            // 小于设定值
                            sb.append("正常,当前压力小于设定值");
                            massSendMsg(sb.toString());
                        } else {
                            // 大于设定值
                            sb.append("二级警报,当前压力大于设定值，许用压力未知，是否到达一级警报未知");
                            massSendMsg(sb.toString());
                        }

                    }
                    // 都不为null的情况
                    if (!StringUtils.isEmpty(allowableStress) && !StringUtils.isEmpty(designPressure)) {
                        // 超过许用压力一级警报
                        if (pressureSimpiperes > Double.parseDouble(allowableStress)) {
                            // 超过许用压力一级警报
                            sb.append("一级警报,当前压力大于许用值");
                            massSendMsg(sb.toString());
                        }else if(pressureSimpiperes > Double.parseDouble(designPressure)){
                            sb.append("二级警报,当前压力在设定值与许用值之间");
                            massSendMsg(sb.toString());
                        }else{
                            // 小于设定值
                            sb.append("正常,当前压力小于设定值");
                            massSendMsg(sb.toString());
                        }
                    }
                }
            }

        }


    }

    public void sendType(){

    }

    public void massSendMsg(String msg) {
        CopyOnWriteArraySet<WebSocketService> massObject = getMassObject();
        if (!CollectionUtil.isEmpty(massObject)) {
            // 遍历set消息群发
            for (WebSocketService webSocketService : massObject) {
                try {
                    webSocketService.getSession().getBasicRemote().sendText(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public CopyOnWriteArraySet<WebSocketService> getMassObject() {
        CopyOnWriteArraySet<WebSocketService> webSocketSet = null;
        try {
            Class<WebSocketService> aClass = WebSocketService.class;
            Field field = aClass.getDeclaredField("webSocketSet");
            webSocketSet = (CopyOnWriteArraySet<WebSocketService>) field.get(aClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return webSocketSet;
    }

    public PropertyValueExample conditin(String elementrealnameEle, Long workid, Integer propertyId) {
        PropertyValueExample propertyValueExample = new PropertyValueExample();
        propertyValueExample.createCriteria().andElementrealnameEleEqualTo(elementrealnameEle)
                .andWorkidWorkEqualTo(workid).andPropertyidProEqualTo(propertyId);
        return propertyValueExample;
    }

}
