/** 
 * @file: GetConfigValue.java 
 * @Package： com.ywjs.common.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年12月4日 下午2:21:06 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.common.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.ywjs.common.constant.CodeMsg;
import com.ywjs.exception.GlobalException;
import com.ywjs.model.vo.HeatingFurnaceVO;
import com.ywjs.model.vo.SingleWellVO;
import com.ywjs.model.vo.YardVO;
import com.ywjs.service.HttpClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GetConfigValue
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年12月4日 下午2:21:06
 */
@Component
public class GetRealTimeDataUtil{
    
    @Autowired
    HttpClientService client;
    
    @Value("${realtime.data.interface.ip}")
    public String ip;
    @Value("${realtime.data.interface.url}")
    public String url;
    @Value("${realtime.data.interface.yardServiceCode}")
    public String yardServiceCode;
    @Value("${realtime.data.interface.singleWellServiceCode}")
    public String singleWellServiceCode;
    @Value("${realtime.data.interface.heatingFurnaceServiceCode}")
    public String heatingFurnaceServiceCode;
    @Value("${app_key}")
    public String app_key;
        
    /**
     * @Description: TODO(递归获取实时数据) @author： 2019年11月29日 周伟 创建初始版本
     * @param realtimedataSim
     * @throws Exception
     */
    public void getRecursiveRealTimeData( String realtimedataSim,
            List<YardVO> yardList, List<SingleWellVO> singleWellList, List<HeatingFurnaceVO> heatingFurnaceList)
            throws Exception {

        // 请求地址公共部分
        String address = ip + url;

        /** 2.获取站场实时数据 */
        String realAddress = address + yardServiceCode;
        List<YardVO> callYardVOList = callInterface(realAddress, realtimedataSim, YardVO.class);
        /** 3.获取单井实时数据 */
        realAddress = address + singleWellServiceCode;
        List<SingleWellVO> callSingleWellVOList = callInterface(realAddress,  realtimedataSim, SingleWellVO.class);
        /** 4.获取加热炉实时数据 */
        realAddress = address + heatingFurnaceServiceCode;
        List<HeatingFurnaceVO> callHeatingFurnaceVOList = callInterface(realAddress,  realtimedataSim, HeatingFurnaceVO.class);

        // 递归条件
        if (CollectionUtils.isEmpty(callYardVOList) || CollectionUtils.isEmpty(callSingleWellVOList)
                || CollectionUtils.isEmpty(callHeatingFurnaceVOList)) {
            // 获取上一分钟日期字符串
            long time = 60 * 1000;// 1分钟
            Date parseDate = DateUtils.parseDate(realtimedataSim, "yyyy-MM-dd HH:mm:ss");
            Date parseDateUpdate = new Date(parseDate.getTime() - time);// 1分钟前的时间
            realtimedataSim = DateUtils.formatDate(parseDateUpdate, "yyyy-MM-dd HH:mm:ss");
            // 递归获取上一分钟数据
            getRecursiveRealTimeData(realtimedataSim, yardList, singleWellList,
                    heatingFurnaceList);
        }

        // 递归结束条件
        if (!CollectionUtils.isEmpty(callYardVOList) && !CollectionUtils.isEmpty(callSingleWellVOList)
                && !CollectionUtils.isEmpty(callHeatingFurnaceVOList)) {
            yardList.addAll(callYardVOList);
            singleWellList.addAll(callSingleWellVOList);
            heatingFurnaceList.addAll(callHeatingFurnaceVOList);
            return;
        }

    }

    /**
     * @Description: TODO(HTTPClient调用实时数据接口) @author： 2019年11月28日 周伟 创建初始版本
     * @param address
     * @param realtimedataSim
     * @param clazz
     * @return
     */
    public <T> List<T> callInterface(String address,  String realtimedataSim, Class<T> clazz)
            throws IOException {
        // 封装查询条件
        Map<String, Object> yardMap = new HashMap<String, Object>();
        yardMap.put("app_key", app_key);
        yardMap.put("condition", "sj='"+realtimedataSim+"'");
        
        // 2.1 获取实时数据
        String yardJsonData = null;
        try {
            yardJsonData = client.doGet(address, yardMap).toLowerCase();
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.PGGWMO_REALTIMEINTERFACE_ERROR);
        }
        JsonNode data = ObjectUtil.mapper.readTree(yardJsonData);
        // 获取返回的状态（成功或异常）
        JsonNode statusCode = data.path("statuscode");
        if (!("000".equals(statusCode.asText()))) {
            throw new GlobalException(CodeMsg.PGGWMO_REALTIMEINTERFACE_ERROR);
        }
        // 获取数据部分
        JsonNode yardJsonDataList = data.path("data").path("datalist");

        // 2.2 解析实时数据
        List<T> list = null;
        if (yardJsonDataList.isArray() && yardJsonDataList.size() > 0) {
            list = ObjectUtil.mapper.readValue(yardJsonDataList.traverse(),
                    ObjectUtil.mapper.getTypeFactory().constructCollectionType(List.class, clazz));
        }
        return list;
    }

    

}
