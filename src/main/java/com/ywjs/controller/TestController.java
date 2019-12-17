/**
 * @file: TestController.java
 * @Package： com.ywjs.controller
 * @Description: TODO(用一句话描述该文件做什么)
 * @author： 周伟
 * @date： 2019年11月26日 下午3:15:06 
 * @version： V1.0
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */
package com.ywjs.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.ywjs.common.utils.GetRealTimeDataUtil;
import com.ywjs.common.utils.ObjectUtil;
import com.ywjs.common.utils.SpringContextUtil;
import com.ywjs.common.vo.Result;
import com.ywjs.mapper.*;
import com.ywjs.model.dto.GetRealTimeDataDTO;
import com.ywjs.model.dto.SetRealTiemFzmnDTO;
import com.ywjs.model.entity.Element;
import com.ywjs.model.entity.ElementExample;
import com.ywjs.model.entity.RealtimesimPipeResult;
import com.ywjs.model.vo.ElementVO;
import com.ywjs.model.vo.PipelineVO;
import com.ywjs.model.vo.StationandeLementVO;
import com.ywjs.model.vo.YardVO;
import com.ywjs.service.HttpClientService;
import com.ywjs.service.TimingService;
import com.ywjs.service.impl.PipeNetworkModelServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TestController
 * @Description TODO(这里用一句话描述这个类的作用)
 * @Author 周伟
 * @Date 2019年11月26日 下午3:15:06
 */
@RestController
@RequestMapping("/test")
public class TestController implements ApplicationContextAware{

    /** 上下文对象实例*/
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    /** 工程dao */
    @Autowired
    private ProjectMapper projectMapper;
    /** 工程备份dao */
    @Autowired
    private ProjectAffiliatedMapper projectAffiliatedMapper;
    /** 复杂查询dao */
    @Autowired
    CustomMapper customMapper;
    @Autowired
    HttpClientService client;
    /** 属性值表dao*/
    @Autowired
    PropertyValueMapper propertyValueMapper;
    /** 元件拓扑表dao*/
    @Autowired
    ElementMapper elementMapper;
    @Autowired
    GetRealTimeDataUtil getConfigValue;
    @Autowired
    RealtimesimPipeResultMapper realtimesimPipeResultMapper;

    @RequestMapping("/testMySql")
    public  Object testMySql(){
        List<RealtimesimPipeResult> realtimesimPipeResults = realtimesimPipeResultMapper.selectByCondition(133L,"2019-12-12 10:40:00","FL 69");
        return realtimesimPipeResults;
    }

    @RequestMapping("/queryAll")
    public Object queryAll(){
        List<Element> elements = elementMapper.selectByExample(null);
        return elements;
    }

    @RequestMapping("/testInsertBatch")
    public void testInsertBatch(){
        ArrayList<Element> list = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            Element element = new Element();
            element.setElementidEle(1);
            element.setElementrealnameEle("1");
            element.setElementisstate(1);
            element.setElementtypeEle("1");
            element.setLayeridEle("1");
            element.setNodeendEle("1");
            element.setNodestarEle("1");
            element.setProjectidProaff(1);
            element.setStarxEle(1);
            element.setStaryEle(1);
            list.add(element);
        }
        // 原件拓扑信息表的插入
        elementMapper.insertBatch(list);
    }

    @Autowired
    SpringContextUtil sc;
    @RequestMapping("/testApplicationContextUtil")
    public void testApplicationContextUtil(){
        //GetRealTimeDataUtil 
        GetRealTimeDataUtil getRealTimeDataUtil = (GetRealTimeDataUtil) applicationContext.getBean("getRealTimeDataUtil");
        TimingService timingService = (TimingService) applicationContext.getBean("timingService");
        PipeNetworkModelServiceImpl bean = (PipeNetworkModelServiceImpl)applicationContext.getBean("pipeNetworkModelService");
        PipeNetworkModelServiceImpl ps = (PipeNetworkModelServiceImpl)sc.getApplicationContext().getBean(PipeNetworkModelServiceImpl.class);
        System.out.println(ps+""+bean);
    }

    @RequestMapping("/testGetConfigValue")
    public Object testGetConfigValue(){
        System.out.println(getConfigValue.app_key);
        System.out.println(getConfigValue.ip);

//        System.out.println(getConfigValue.getApp_key());
//        System.out.println(getConfigValue.getIp());
        return null;

    }


    @Value("${realtime.data.interface.ip}")
    public String ip;
    @Value("${realtime.data.interface.url}")
    public String url;

    @RequestMapping("/testValue")
    public void testValue(){
        new Thread(new Runnable() {
            @Value("${realtime.data.interface.ip}")
            public String ip;
            @Value("${realtime.data.interface.url}")
            public String url;
            @Override
            public void run() {
                System.out.println(ip+url);
            }
        }).start();
        System.out.println(ip+url);
    }

    @RequestMapping("/testQueryCondition")
    public Object testQueryCondition(){
        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        list.add("8");
        list.add("7");
        ElementExample elementExample = new ElementExample();
        elementExample.createCriteria().andProjectidProaffEqualTo(121L)
        .andElementtypeEleIn(list);
        List<Element> listElement = elementMapper.selectByExample(elementExample);
        return listElement;
    }

    @SuppressWarnings("static-access")
    @RequestMapping("/testReceiveParameters")
    public Result testReceiveParameters(@RequestBody SetRealTiemFzmnDTO setRealTiemFzmnDTO){
        List<?> list = setRealTiemFzmnDTO.getSimsettinglist();
        Map map2 = (Map)list.get(0);
        System.out.println(list+"==="+map2.get("key"));
        Map<String,String> map = new HashMap<>();
        map.put("key", "a");
        map.put("value", "22");
        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(map);
        arrayList.add(map);
        SetRealTiemFzmnDTO setRealTiemFzmnDTO2 = new SetRealTiemFzmnDTO();
        setRealTiemFzmnDTO2.setSimsettinglist(arrayList);
        System.out.println(setRealTiemFzmnDTO2);
        return new Result().success(setRealTiemFzmnDTO);
    }

    @RequestMapping("/testQueryProject")
    public Result queryProject(String CREATEDATE_PRO){
        System.out.println(CREATEDATE_PRO);
        return new Result().success(CREATEDATE_PRO);
    }
    @RequestMapping("/testHttpClient")
    public Object testHttpClient(String data ) throws Exception{
        HashMap<String,Object> map = new HashMap<>();
        map.put("CREATEDATE_PRO", data);
        String doGet = client.doGet("http://127.0.0.1:9999/test/testQueryProject", map);

        return doGet;
    }

    public <T> List<T> callInterface(JsonNode jsonDataList,Class classz) throws Exception{
        List<T> list = null;
        if(jsonDataList.isArray()&&jsonDataList.size()>0){
             list = ObjectUtil.mapper.readValue(jsonDataList.traverse(),
             ObjectUtil.mapper.getTypeFactory().
             constructCollectionType(List.class, classz));
         }
        return  list;
    }

    @RequestMapping("/testParm")
    public Object testParm() throws Exception{
        String str = "{\"statusCode\":\"000\",\"message\":\"成功\",\"data\":{\"total\":0,\"dataList\":[{\"ckyl\":\"5\",\"zcmc\":\"普光101集气站\",\"jkyl\":\"8\",\"ckll\":\"20.5\",\"sj\":\"2019-11-27 13:15:02.0\",\"ckylsdz\":\"9\",\"ckwd\":\"4.1\",\"czgxqdf\":\"2.56\",\"jkwd\":\"3.5\",\"ckllsdz\":\"23.6\",\"ckllxzz\":\"2.28\"}]}}";
        String str2 = "{\"statusCode\":\"000\",\"message\":\"成功\",\"data\":{\"total\":0,\"dataList\":[{\"CKYL\":\"5\",\"ZCMC\":\"普光101集气站\",\"JKYL\":\"8\",\"CKLL\":\"20.5\",\"SJ\":\"2019-11-27 13:15:02.0\",\"CKYLSDZ\":\"9\",\"CKWD\":\"4.1\",\"CZGXQDF\":\"2.56\",\"JKWD\":\"3.5\",\"CKLLSDZ\":\"23.6\",\"CKLLXZZ\":\"2.28\"}]}}";
        str2 = str2.toLowerCase();
        JsonNode data=ObjectUtil.mapper.readTree(str2);
        JsonNode jsonDataList = data.path("data").path("datalist");
        List<YardVO> list = callInterface(jsonDataList,YardVO.class);
        
        /*ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(new User("周伟",23));
        arrayList.add(new User("小明",15));
        JSONArray jsonArray=new JSONArray(arrayList);
        System.out.println(jsonArray.toString());
        String jsonData = jsonArray.toString();
        
        List<User> pList=null;
        JsonNode data=ObjectUtil.mapper.readTree(jsonData);
        if(data.isArray()&&data.size()>0){
            pList = ObjectUtil.mapper.readValue(data.traverse(),
            ObjectUtil.mapper.getTypeFactory().
            constructCollectionType(List.class, User.class));
        }*/
        return list;
    }

    @RequestMapping("/selectJoint")
    public Object test(){
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(255L);
        arrayList.add(243L);
        //List<SimulationlistVO> selectJoint = customMapper.selectJointSimulation(arrayList);
        //return selectJoint;
        HashMap<String,Object> hashMap = new HashMap<>();
        return null;
    }

    @RequestMapping("/data")
    public Object data(){
        // 井、加热炉
        ElementVO elementVO = new ElementVO();
        elementVO.setElementid("101-2H");
        elementVO.setElementname("普光101-2H");
        elementVO.setElementtype("well");

//        ElementVO elementVO2 = new ElementVO();
//        elementVO.setElementid("102-1");
//        elementVO.setElementname("普光102-1");
//        elementVO.setElementtype("well");
        // 加热炉
        ElementVO elementVO3 = new ElementVO();
        elementVO3.setElementid("2H");
        elementVO3.setElementname("2H井加热炉");
        elementVO3.setElementtype("heat");


        PipelineVO pipelineVO = new PipelineVO();
        pipelineVO.setPipelineid("pl0");
        pipelineVO.setPipelinename("pl101");

        // 站场
        StationandeLementVO stationandeLementVO = new StationandeLementVO();
        stationandeLementVO.setStationid("Station1");//
        stationandeLementVO.setStationname("普光101集气站");
        StationandeLementVO stationandeLementVO2 = new StationandeLementVO();
        stationandeLementVO2.setStationid("Station2");//
        stationandeLementVO2.setStationname("普光102集气站");

        // 
        ArrayList<ElementVO> elementVOList = new ArrayList<>();
        elementVOList.add(elementVO);
        elementVOList.add(elementVO3);

        ArrayList<PipelineVO> pipelineVOList = new ArrayList<>();
        pipelineVOList.add(pipelineVO);

        stationandeLementVO.setElementlist(elementVOList);
        //stationandeLementVO.setPipelinelist(pipelineVOList);

        // 站场
        ArrayList<StationandeLementVO> stationandeLementVOList = new ArrayList<>();
        stationandeLementVOList.add(stationandeLementVO);
        stationandeLementVOList.add(stationandeLementVO2);

        GetRealTimeDataDTO getRealTimeDataDTO = new GetRealTimeDataDTO();
        getRealTimeDataDTO.setProjectidProaff("22");
        getRealTimeDataDTO.setRealtimedataSim("2019-11-29 13:15:00");
        getRealTimeDataDTO.setRemarkSim("备注");
        getRealTimeDataDTO.setSimsourceSim("来源");


        getRealTimeDataDTO.setStationandelement(stationandeLementVOList);
        return getRealTimeDataDTO;
    }



}
