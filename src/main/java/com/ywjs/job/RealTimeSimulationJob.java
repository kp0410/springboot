/**
 * @file: RealTimeSimulationJob.java
 * @Package： com.ywjs.job
 * @Description: TODO(用一句话描述该文件做什么)
 * @author： 周伟
 * @date： 2019年12月3日 下午5:38:32
 * @version： V1.0
 * @par 版权信息：
 * 2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */
package com.ywjs.job;

import com.ywjs.common.constant.CodeMsg;
import com.ywjs.common.utils.DateUtils;
import com.ywjs.common.utils.GetRealTimeDataUtil;
import com.ywjs.common.utils.RealTimeDataUtil;
import com.ywjs.exception.GlobalException;
import com.ywjs.model.dto.ElementPropertyDTO;
import com.ywjs.model.vo.*;
import com.ywjs.pythontookit.controller.GetRealtimePipesim;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName RealTimeSimulationJob
 * @Description TODO(实时模拟计算job)
 * @Author 周伟
 * @Date 2019年12月3日 下午5:38:32
 */
public class RealTimeSimulationJob implements Runnable {

    GetRealTimeDataUtil getConfigValueUtil;
    GetRealtimePipesim getRealtimePipesim;
    Long id;
    Map<String, List<RealTiemSimulationVO>> simulationMap; //查询的数据（设备编号+设备名）用于与实时数据组织数据

    public RealTimeSimulationJob(GetRealTimeDataUtil getConfigValueUtil, Map<String, List<RealTiemSimulationVO>> simulationMap,
            GetRealtimePipesim getRealtimePipesim, Long id) {
        this.getConfigValueUtil = getConfigValueUtil;
        this.simulationMap = simulationMap;
        this.getRealtimePipesim = getRealtimePipesim;
        this.id = id;
    }

    @Override
    public void run() {
//        // 请求地址公共部分
//        String address = getConfigValueUtil.ip + getConfigValueUtil.url;
        /** 封装实时数据的容器 */
        List<YardVO> yardList = new ArrayList<>(); // 站场
        List<SingleWellVO> singleWellList = new ArrayList<>(); // 井
        List<HeatingFurnaceVO> heatingFurnaceList = new ArrayList<>(); // 加热炉
        // 获取当前系统时间前5分钟的时间字符串
        long time = 1000 * 60 * 5;
        Date date = new Date(System.currentTimeMillis() - time);
        String formatDate = DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss");
        String realtimedataSim = formatDate.substring(0, formatDate.length() - 2) + "00";
        // 递归获取实时数据，并将数据放入容器中
        try {
            getConfigValueUtil.getRecursiveRealTimeData( realtimedataSim, yardList, singleWellList,
                    heatingFurnaceList);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.TIMINGTASK_GETREALTIMEDATA_ERROR);
        }

        // 封装返回数据的容器
        ArrayList<RealTiemSimulationVO> resultList = new ArrayList<>();
        try {
            // 5.1解析站场数据
            for (YardVO yardVO : yardList) {
                List<RealTiemSimulationVO> yardRealTiemSimulation = RealTimeDataUtil.reflectObjToSimulation(yardVO, simulationMap);
                resultList.addAll(yardRealTiemSimulation);
            }
            // 5.2 解析井口数据
            for (SingleWellVO singleWellVO : singleWellList) {
                resultList.addAll(RealTimeDataUtil.reflectObjToSimulation(singleWellVO, simulationMap));
            }
            // 5.3 解析加热炉数据
            for (HeatingFurnaceVO heatingFurnaceVO : heatingFurnaceList) {
                resultList.addAll(RealTimeDataUtil.reflectObjToSimulation(heatingFurnaceVO, simulationMap));
            }
            List<ElementPropertyDTO> elementPropertyDTOList = new ArrayList<>();
            for (RealTiemSimulationVO item : resultList) {
                if (item.getPropertyvalue() != null) {
                    ElementPropertyDTO elementPropertyDTO = new ElementPropertyDTO();
                    elementPropertyDTO.setElementid(item.getElementid());
                    elementPropertyDTO.setElementname(item.getElementname());
                    // 元件类型 之后再完善
                    elementPropertyDTO.setElementtype(0);
                    elementPropertyDTO.setPropertykey(item.getPropertykey());
                    elementPropertyDTO.setPropertyvalue(item.getPropertyvalue());
                    elementPropertyDTOList.add(elementPropertyDTO);
                }
            }
            SetRealTime setRealTime = new SetRealTime();
            setRealTime.setRealtimeSimid(Integer.parseInt(id + ""));
            setRealTime.setElementpropertylist(elementPropertyDTOList);

            // 调用仿真模拟计算，将resultList作为参数传入
            getRealtimePipesim.setrealtiemfzmn(setRealTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
