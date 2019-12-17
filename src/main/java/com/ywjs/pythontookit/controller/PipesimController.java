package com.ywjs.pythontookit.controller;


import com.ywjs.mapper.RealtimesimPipeResultTblMapper;
import com.ywjs.mapper.RealtimesimResultTblMapper;
import com.ywjs.model.dto.*;
import com.ywjs.model.entity.*;

import com.ywjs.model.vo.SetRealTime;
import com.ywjs.pythontookit.service.PipesimService;
import com.ywjs.pythontookit.pipesimutil.PipesimUtil;
import com.ywjs.service.PipeNetworkModelService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
public class PipesimController implements ApplicationContextAware {

    @Autowired
    PipesimService pipesimService;
    @Autowired
    PipeNetworkModelService pipeNetworkModelService;
//    @Autowired
//    TimingService timingService;


    @Autowired
    RealtimesimResultTblMapper realtimesimResultTblMapper;

    @Value("${pips.python.variableurl}")
    private String variableUrl;
    @Value("${pips.model.url}")
    private String modelPath;

    /** 上下文对象实例*/
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    @ResponseBody
    @RequestMapping(value = "/run", method = RequestMethod.POST)
//    public void run(String filePath,String[][] updateData,String[][] equation){
    public String run() throws IOException {
        //model文件的复制
        String pipsPath = PipesimUtil.createPips(modelPath);
        String pipsFilePath = pipsPath.replace("\\", "/");//复制的pips文件路径的修改  把 \ 改为 /
        //创建py文件
        String pyFilePath = PipesimUtil.createPyFile();
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new FileOutputStream(pyFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String contect;
        String open = pipesimService.open(pipsFilePath);
//        String update = new PipesimController().batchUpdate(updateData);
//        String setSimSetting = new PipesimController().setSimSetting(equation);
        String save = pipesimService.save(pipsFilePath);
        String branch = pipesimService.resultBranch(); //返回管道数据
        String node = pipesimService.resultNode(); //返回节点数据
        String close = pipesimService.close();
        contect = (open + save + branch + node + close);
        printStream.println(contect);
        printStream.close();

        //删除30分钟前生成的文件
        Date date = new Date(System.currentTimeMillis() - 1000 * 60 * 30);
        File pyfile = new File(PipesimUtil.DELETEPY);
        File pipsfile = new File(PipesimUtil.DELETEPIPS);
        File[] pyfiles = pyfile.listFiles();
        File[] pipsfiles = pipsfile.listFiles();
        for (int i = 0; i < pyfiles.length ; i++) {
            File file =  pyfiles[i];
            if (new Date(file.lastModified()).before(date)){
                file.delete();
            }
        }
        for (int i = 0; i < pipsfiles.length ; i++) {
            File file =  pipsfiles[i];
            if (new Date(file.lastModified()).before(date)){
                file.delete();
            }
        }


        long start = System.currentTimeMillis();
        String outputResult = PipesimUtil.outputResult(variableUrl, pyFilePath);
        long end = System.currentTimeMillis();
        //返回数据处理为管道和节点两个数组
        String[] data = outputResult.split("&");
        //TODO for循环
        String branchdata = data[0];//管道数据
        String nodedata = data[1];//节点数据
        //把节点数据插入到数据库
        List<SimeleNodeResultTbl> simeleNodeResultTblList = PipesimUtil.nodeDataChuLi(nodedata);//节点数据的处理及返回节点数据的list集合
        SimeleNodeResultTbl simeleNodeResultTbl = new SimeleNodeResultTbl();
        //从list集合中取出对应的值并插入数据库
        for (int i = 0; i <simeleNodeResultTblList.size() ; i++) {
            simeleNodeResultTbl.setSimulationidSim(simeleNodeResultTblList.get(i).getSimulationidSim());//仿真模拟方案表编号
//            simeleNodeResultTbl.setSimulationidSim(123);//仿真模拟方案表编号
            simeleNodeResultTbl.setFlowRealsimnoderes(simeleNodeResultTblList.get(i).getFlowRealsimnoderes());//流量
            simeleNodeResultTbl.setTemperatureSimnoderes(simeleNodeResultTblList.get(i).getTemperatureSimnoderes());//温度
            simeleNodeResultTbl.setPressureSimpiperes(simeleNodeResultTblList.get(i).getPressureSimpiperes());//压力
            simeleNodeResultTbl.setElementnameSimnoderes(simeleNodeResultTblList.get(i).getElementnameSimnoderes());//设备名称
            simeleNodeResultTbl.setElementidSimnoderes(simeleNodeResultTblList.get(i).getElementidSimnoderes());//设备编号
            pipesimService.insertnode(simeleNodeResultTbl);
        }
        //把管道数据插入到数据库
        List<SimelePipeResultTbl> simelePipeResultTbls = PipesimUtil.branchDataChuLi(branchdata);//管道数据的处理及返回节点数据的list集合
        SimelePipeResultTbl simelePipeResultTbl = new SimelePipeResultTbl();
        //从list集合中取出对应的值并插入数据库
        for (int i = 0; i < simelePipeResultTbls.size() ; i++) {
            simelePipeResultTbl.setPipeidSimpiperes(simelePipeResultTbls.get(i).getPipeidSimpiperes());//管道编号
            simelePipeResultTbl.setLiquidSimpiperes(simelePipeResultTbls.get(i).getLiquidSimpiperes());//持液率
            simelePipeResultTbl.setFlowSimpiperes(simelePipeResultTbls.get(i).getFlowSimpiperes());//流速
            simelePipeResultTbl.setPipenameSimpiperes(simelePipeResultTbls.get(i).getPipenameSimpiperes());//管道名称
            simelePipeResultTbl.setSimulationidRealsim(simelePipeResultTbls.get(i).getSimulationidRealsim());//仿真模拟方案表编号
            simelePipeResultTbl.setMileageSimpiperes(simelePipeResultTbls.get(i).getMileageSimpiperes());//里程
            simelePipeResultTbl.setTemperatureSimpiperes(simelePipeResultTbls.get(i).getTemperatureSimpiperes());//温度
            simelePipeResultTbl.setPressureSimpiperes(simelePipeResultTbls.get(i).getPressureSimpiperes());//压力
            simelePipeResultTbl.setElevationSimpiperes(simelePipeResultTbls.get(i).getElevationSimpiperes());//高程
            pipesimService.insertbranch(simelePipeResultTbl);
        }
        System.out.println(end - start);
        return outputResult;
    }

    /**
     * 测试定时器调用实时仿真模拟计算接口
     */
    @Autowired
    GetRealtimePipesim getRealtimePipesim;
    @Autowired
    RealtimesimPipeResultTblMapper realtimesimPipeResultTblMapper;
    @ResponseBody
    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public void test() throws IOException {
        //TODO 定时器调用实时仿真模拟计算测试
        SetRealTime setRealTime = new SetRealTime();
        setRealTime.setRealtimeSimid(123);
        List<ElementPropertyDTO> ddd=new ArrayList<>();
        setRealTime.setElementpropertylist(ddd);
        getRealtimePipesim.setrealtiemfzmn(setRealTime);
        GetRealtimePipesim getRealtimePipesim = (GetRealtimePipesim) applicationContext.getBean("getRealtimePipesim");
//       timingService.startCron("session", "0 */1 * * * ?", "setrealtiemfzmn", setRealTime, getRealtimePipesim);
    }

    /**
     * 获取管段实时模拟结果测试
     * @return
     */
//    @SuppressWarnings("SpringMVCInitBinder")
//    @InitBinder
//    @ResponseBody
//    @RequestMapping(value = "/test", method = RequestMethod.POST)
////    public Object getPipeFzjg(Date realtime, List<PiPeidList> pipeidlist){
//    public Object getPipeFzjg() throws ParseException {
////        Integer simulationid = pipesimService.selectSimulationidByRealtime(date);//通过实时模拟的时间从实时仿真结果总表查询实时仿真模拟总表ID
//        Integer simulationid = 79;
//        BranchData branchData = new BranchData();
//        List<PiPeidList> piPeidList = new ArrayList<>();
//        piPeidList.add(new PiPeidList("M502","M502"));
//        piPeidList.add(new PiPeidList("P202","P202"));
//        piPeidList.add(new PiPeidList("FL 51","FL 51"));
//        BrachProperty brachProperty = null;
//        List branch1 =  new ArrayList<>();//list集合存放管道信息
//        for (int i = 0; i < piPeidList.size(); i++) {
//            String pipeid = piPeidList.get(i).getPipeid();//管线编号
//            String pipename = piPeidList.get(i).getPipename();//管线名称
//            List<RealtimesimPipeResultTbl> branchRealtimeData = pipesimService.selectDataByBranch(simulationid, pipeid, pipename);
//            PipesimProperty pipesimProperty = null;
//            brachProperty = new BrachProperty();
//            brachProperty.setPipeidSimpiperes(pipeid);
//            brachProperty.setPipeName(pipename);
//            List branch =  new ArrayList<>();//list集合存放属性值
//            for (int j = 0; j < branchRealtimeData.size(); j++) {
//                Double elevation = branchRealtimeData.get(j).getElevationSimpiperes();//高程
//                Double flow = branchRealtimeData.get(j).getFlowSimpiperes();//流量
//                Double liquid = branchRealtimeData.get(j).getLiquidSimpiperes();//持液率
//                Double pressure = branchRealtimeData.get(j).getPressureSimpiperes();//压力
//                Double temperature = branchRealtimeData.get(j).getTemperatureSimpiperes();//温度
//                Double mileage = branchRealtimeData.get(j).getMileageSimpiperes();//里程
//                pipesimProperty = new PipesimProperty();
//                pipesimProperty.setElevationSimpiperes(elevation);
//                pipesimProperty.setFlowSimpiperes(flow);
//                pipesimProperty.setLiquidSimpiperes(liquid);
//                pipesimProperty.setMileageSimpiperes(mileage);
//                pipesimProperty.setPressureSimpiperes(pressure);
//                pipesimProperty.setTemperatureSimpiperes(temperature);
//                branch.add(pipesimProperty);
//            }
////            brachProperty.setPropertylist(branch);
//            branch1.add(new BrachProperty(pipeid,pipename,branch));
//        }
////        branchData.setRealtime(realtime);//实时时间
//        branchData.setElementlist(branch1);
//        return JSON.toJSON(branchData);
//    }

    /**
     * 实时仿真模拟计算
     * @param setRealTiemFzmnDTO
     * @throws IOException
     */
//    @ResponseBody
//    @RequestMapping(value = "/123", method = RequestMethod.POST)
//    public void setrealtiemfzmn(SetRealTime setRealTiemFzmnDTO) throws IOException {
//        //model文件的复制
//        String pipsPath = PipesimUtil.createPips(modelPath);
//        String pipsFilePath = pipsPath.replace("\\", "/");//复制的pips文件路径的修改  把 \ 改为 /
//        SetFangZhenMoNiDTO setRealTiemFzmn = new SetFangZhenMoNiDTO();
//        Integer fzmnwj = setRealTiemFzmnDTO.getRealtimeSimid();//仿真模拟结果表外键
////        List<SimSettingDTO> simSettingList = setRealTiemFzmn.getSimsettinglist();//全局设置属性集合
//        List<ElementPropertyDTO> elementPropertyList = setRealTiemFzmnDTO.getElementpropertylist();//批量更新参数集合
//        //实时仿真结果总表
//        RealtimesimResultTbl realtimesimResultTbl = new RealtimesimResultTbl();
//        realtimesimResultTbl.setSimulationidRealsim(fzmnwj);//实时模拟表Id
//        realtimesimResultTbl.setRealtimeSim(new Date());//实时模拟的时间
//        pipesimService.insertShiShiMoNi(realtimesimResultTbl);//把数据插入到实时仿真结果总表中返回自增id
//        Long simulationidRealsimall = realtimesimResultTbl.getSimulationidRealsimall();//获取实时仿真结果总表的自增id
//        String pyFilePath = PipesimUtil.createPyFile();//生成Python文件
//        PrintStream printStream = null;//打印流
//        try {
//            printStream = new PrintStream(new FileOutputStream(pyFilePath));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
////        //TODO 全局设置
////        String[][] simsetting = new String[simSettingList.size()][2];
////        for (int i = 0; i <simSettingList.size() ; i++) {
////            String ssname = simSettingList.get(i).getElementname();//属性名称
////            String ssvalue = simSettingList.get(i).getPropertyvalue();//属性值
////            simsetting[i][0] = ssname;
////            simsetting[i][1] = ssvalue;
////        }
//        //TODO 批量更新
//        String[][] batchUpdate = new String[elementPropertyList.size()][3];
//        for (int i = 0; i < elementPropertyList.size(); i++) {
//            String elementName = elementPropertyList.get(i).getElementname();//设备名称
//            String propertyKey = elementPropertyList.get(i).getPropertykey();//设备属性
//            double propertyValue = elementPropertyList.get(i).getPropertyvalue();//设备属性值
//            batchUpdate[i][0] = elementName;
//            batchUpdate[i][1] = propertyKey;
//            if (propertyKey.equals("Parameters.Source.TEMPERATURE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.wddegcTodegf(propertyValue));
//            } else if (propertyKey.equals("Parameters.Source.PRESSURE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.ylmpaTopsia(propertyValue));
//            } else if (propertyKey.equals("Parameters.Source.GASFLOWRATE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.lsmsTomscfd(propertyValue));
//            } else if (propertyKey.equals("Parameters.Flowline.INNERDIAMETER")){
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.mToIn(propertyValue));
//            }else {
//                batchUpdate[i][2] = String.valueOf(propertyValue);
//            }
//        }
//
//        String open = pipesimService.open(pipsFilePath);//仿真模拟方案表编号
////        String simSetting = pipesimService.setSimSetting(simsetting);
//        String update = pipesimService.update(batchUpdate);
//        String save = pipesimService.save(pipsFilePath);
//        String branch = pipesimService.resultBranch();
//        String node = pipesimService.resultNode();
//        String close = pipesimService.close();
//        String concect = (open + update + save + branch + node + close);
//        printStream.println(concect);
//        printStream.close();
//        String outputResult = PipesimUtil.outputResult(variableUrl, pyFilePath);
//        //返回数据的处理
//        String[] data = outputResult.split("&");
//        String branchdata = data[0];//管道数据
//        String nodedata = data[1];//节点数据
//        //插入仿真模拟实时节点数据
//
//        //把管道数据插入到数据库
//        List<SimelePipeResultTbl> simelePipeResultTbls = PipesimUtil.branchDataChuLi(branchdata);//管道数据的处理及返回节点数据的list集合
//        RealtimesimPipeResultTbl realtimesimPipeResultTbl = new RealtimesimPipeResultTbl();
//        //从list集合中取出对应的值并插入数据库
//        for (int i = 0; i < simelePipeResultTbls.size(); i++) {
//            realtimesimPipeResultTbl.setPipeidSimpiperes(simelePipeResultTbls.get(i).getPipeidSimpiperes());//管道编号
//            realtimesimPipeResultTbl.setLiquidSimpiperes(simelePipeResultTbls.get(i).getLiquidSimpiperes());//持液率
//            realtimesimPipeResultTbl.setFlowSimpiperes(simelePipeResultTbls.get(i).getFlowSimpiperes());//流速
//            realtimesimPipeResultTbl.setPipenameSimpiperes(simelePipeResultTbls.get(i).getPipenameSimpiperes());//管道名称
//            realtimesimPipeResultTbl.setSimulationidRealsimall(simulationidRealsimall.intValue());//仿真模拟方案表编号(实时仿真模拟仿真总表自增id)
//            realtimesimPipeResultTbl.setMileageSimpiperes(simelePipeResultTbls.get(i).getMileageSimpiperes());//里程
//            realtimesimPipeResultTbl.setTemperatureSimpiperes(simelePipeResultTbls.get(i).getTemperatureSimpiperes());//温度
//            realtimesimPipeResultTbl.setPressureSimpiperes(simelePipeResultTbls.get(i).getPressureSimpiperes());//压力
//            realtimesimPipeResultTbl.setElevationSimpiperes(simelePipeResultTbls.get(i).getElevationSimpiperes());//高程
//            pipesimService.insertRealtimeBranch(realtimesimPipeResultTbl);
//        }
//        //把节点数据插入到实时数据库
//        List<SimeleNodeResultTbl> simeleNodeResultTblList = PipesimUtil.nodeDataChuLi(nodedata);//节点数据的处理及返回节点数据的list集合
//        RealtimesimNodeResultTbl realtimesimNodeResultTbl = new RealtimesimNodeResultTbl();
//        //从list集合中取出对应的值并插入数据库
//        for (int i = 0; i < simeleNodeResultTblList.size(); i++) {
//            realtimesimNodeResultTbl.setSimulationidRealsimall(simulationidRealsimall.intValue());//仿真模拟方案表编号(实时仿真模拟仿真总表自增id)
//            realtimesimNodeResultTbl.setFlowRealsimnoderes(simeleNodeResultTblList.get(i).getFlowRealsimnoderes());//流量
//            realtimesimNodeResultTbl.setTemperatureRealsimnoderes(simeleNodeResultTblList.get(i).getTemperatureSimnoderes());//温度
//            realtimesimNodeResultTbl.setPressureRealsimnoderes(simeleNodeResultTblList.get(i).getPressureSimpiperes());//压力
//            realtimesimNodeResultTbl.setElementnameRealsimnoderes(simeleNodeResultTblList.get(i).getElementnameSimnoderes());//设备名称
//            realtimesimNodeResultTbl.setElementidRealsimnoderes(simeleNodeResultTblList.get(i).getElementidSimnoderes());//设备编号
//            pipesimService.insertRealtimeNode(realtimesimNodeResultTbl);
//        }
//
//
//    }


    /**
     * 仿真模拟计算测试
     * @param setFangZhenMoNi
     * @return
     * @throws IOException
     */
//    @PostMapping("/setFangZhenMoNi")
//    public Result setFangZhenMoNi(@RequestBody SetFangZhenMoNiDTO setFangZhenMoNi) throws IOException {
//        //model文件的复制
//        String pipsPath = PipesimUtil.createPips(modelPath);
//        String pipsFilePath = pipsPath.replace("\\", "/");//复制的pips文件路径的修改  把 \ 改为 /
//
//        SetFangZhenMoNiDTO setFangZhenMoNiDTO = setFangZhenMoNi;
//        Integer fzmnwj = setFangZhenMoNiDTO.getSimulationidSim();//仿真模拟结果表外键
//        List<SimSettingDTO> simSettingList = setFangZhenMoNiDTO.getSimsettinglist();//全局设置属性集合
//        List<ElementPropertyDTO> elementPropertyList = setFangZhenMoNiDTO.getElementpropertylist();//批量更新参数集合
//
//        //TODO 删除
////        RealtimesimResultTbl realtimesimResultTbl = new RealtimesimResultTbl();
////        realtimesimResultTbl.setSimulationidRealsim(123);//实时模拟表Id
////        realtimesimResultTbl.setRealtimeSim(new Date());//实时模拟的时间
////        pipesimService.insertShiShiMoNi(realtimesimResultTbl);//把数据插入到实时仿真结果总表中
//
//        String pyFilePath = PipesimUtil.createPyFile();//生成Python文件
//        PrintStream printStream = null;//打印流
//        try {
//            printStream = new PrintStream(new FileOutputStream(pyFilePath));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
////        //TODO 全局设置
////        List list = PipesimUtil.simSettingChuLi(simSettingList);
////        Object[][] flow = new Object[0][];
////        Object[][] heat = new Object[0][];
////        Object[][] sim = new Object[0][];
////        for (int i = 0; i < list.size(); i++) {
////            switch (i){
////                case 0:
////                    flow = (Object[][]) list.get(i);
////                    break;
////                case 1:
////                    heat = (Object[][]) list.get(i);
////                    break;
////                case 2:
////                    sim = (Object[][]) list.get(i);
////                    break;
////            }
////        }
//
//        //TODO 批量更新
//        List propertyValues = new ArrayList();//设备属性值集合
//        List elementNames = new ArrayList();//设备名称集合
//        List propertyKeys = new ArrayList();//设备属性集合
//        for (int i = 0; i < elementPropertyList.size(); i++) {
//            Double propertyValue = elementPropertyList.get(i).getPropertyvalue();//设备属性值
//            if (propertyValue != null || propertyValue.doubleValue() != 0) {
//                propertyValues.add(propertyValue);
//                String elementName = elementPropertyList.get(i).getElementname();//设备名称
//                elementNames.add(elementName);
//                String propertyKey = elementPropertyList.get(i).getPropertykey();//设备属性
//                propertyKeys.add(propertyKey);
//            }
//        }
//        String[][] batchUpdate = new String[propertyValues.size()][3];
//        for (int i = 0; i <propertyValues.size() ; i++) {
//            Double propertyValue = (Double) propertyValues.get(i);
//            String propertyKey = (String) propertyKeys.get(i);
//            String elementName = (String) elementNames.get(i);
//            batchUpdate[i][0] = elementName;
//            batchUpdate[i][1] = propertyKey;
//            if (propertyKey.equals("Parameters.Source.TEMPERATURE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.wddegcTodegf(propertyValue));
//            } else if (propertyKey.equals("Parameters.Source.PRESSURE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.ylmpaTopsia(propertyValue));
//            } else if (propertyKey.equals("Parameters.Source.GASFLOWRATE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.lsmsTomscfd(propertyValue));
//            } else if (propertyKey.equals("Parameters.Flowline.INNERDIAMETER")){
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.mToIn(propertyValue));
//            }else {
//                batchUpdate[i][2] = String.valueOf(propertyValue);
//            }
//        }
//
//        String open = pipesimService.open(pipsFilePath);//仿真模拟方案表编号
////        //全局变量
////        String setting = null;
////        if (sim.length!=0 ||sim != null){
////            String simSetting = pipesimService.setSimSetting((String[][]) sim);
////            setting += simSetting;
////        }
////        if (flow.length!=0 || flow != null){
////            String globalFlow = pipesimService.setGlobalFlow((String[][]) flow);
////            setting += globalFlow;
////        }
////        if (heat.length != 0 || heat != null){
////            String globalHeat = pipesimService.setGlobalHeat((String[][]) heat);
////            setting += globalHeat;
////        }
////        String update = null;
////        if (batchUpdate.length != 0 || batchUpdate != null) {
////            update = pipesimService.update(batchUpdate);
////        }
//
//        String update = pipesimService.update(batchUpdate);
//        String save = pipesimService.save(pipsFilePath);
//        String branch = pipesimService.resultBranch();
//        String node = pipesimService.resultNode();
//        String close = pipesimService.close();
//        String concect = (open + update + save + branch + node + close);
//        printStream.println(concect);
//        printStream.close();
//        String outputResult = PipesimUtil.outputResult(variableUrl, pyFilePath);
//        //返回数据的处理
//        String[] data = outputResult.split("&");
//        String branchdata = data[0];//管道数据
//        String nodedata = data[1];//节点数据
//
//
//
//        //插入仿真模拟实时节点数据
//        //把节点数据插入到数据库
////        List<SimeleNodeResultTbl> simeleNodeResultTblList = PipesimUtil.nodeDataChuLi(nodedata);//节点数据的处理及返回节点数据的list集合
////        SimeleNodeResultTbl simeleNodeResultTbl = new SimeleNodeResultTbl();
//        //从list集合中取出对应的值并插入数据库
////        for (int i = 0; i < simeleNodeResultTblList.size(); i++) {
////            simeleNodeResultTbl.setSimulationidSim(fzmnwj);//仿真模拟方案表编号
////            simeleNodeResultTbl.setFlowRealsimnoderes(simeleNodeResultTblList.get(i).getFlowRealsimnoderes());//流量
////            simeleNodeResultTbl.setTemperatureSimnoderes(simeleNodeResultTblList.get(i).getTemperatureSimnoderes());//温度
////            simeleNodeResultTbl.setPressureSimpiperes(simeleNodeResultTblList.get(i).getPressureSimpiperes());//压力
////            simeleNodeResultTbl.setElementnameSimnoderes(simeleNodeResultTblList.get(i).getElementnameSimnoderes());//设备名称
////            simeleNodeResultTbl.setElementidSimnoderes(simeleNodeResultTblList.get(i).getElementidSimnoderes());//设备编号
////            pipesimService.insertnode(simeleNodeResultTbl);
////        }
//        //把管道数据插入到数据库
////        List<SimelePipeResultTbl> simelePipeResultTbls = PipesimUtil.branchDataChuLi(branchdata);//管道数据的处理及返回节点数据的list集合
////        SimelePipeResultTbl simelePipeResultTbl = new SimelePipeResultTbl();
//        //从list集合中取出对应的值并插入数据库
////        for (int i = 0; i < simelePipeResultTbls.size(); i++) {
////            simelePipeResultTbl.setPipeidSimpiperes(simelePipeResultTbls.get(i).getPipeidSimpiperes());//管道编号
////            simelePipeResultTbl.setLiquidSimpiperes(simelePipeResultTbls.get(i).getLiquidSimpiperes());//持液率
////            simelePipeResultTbl.setFlowSimpiperes(simelePipeResultTbls.get(i).getFlowSimpiperes());//流速
////            simelePipeResultTbl.setPipenameSimpiperes(simelePipeResultTbls.get(i).getPipenameSimpiperes());//管道名称
////            simelePipeResultTbl.setSimulationidRealsim(fzmnwj);//仿真模拟方案表编号
////            simelePipeResultTbl.setMileageSimpiperes(simelePipeResultTbls.get(i).getMileageSimpiperes());//里程
////            simelePipeResultTbl.setTemperatureSimpiperes(simelePipeResultTbls.get(i).getTemperatureSimpiperes());//温度
////            simelePipeResultTbl.setPressureSimpiperes(simelePipeResultTbls.get(i).getPressureSimpiperes());//压力
////            simelePipeResultTbl.setElevationSimpiperes(simelePipeResultTbls.get(i).getElevationSimpiperes());//高程
////            pipesimService.insertbranch(simelePipeResultTbl);
////        }
//
//
//
//        if (outputResult == null) {
//            return Result.build(500101, "参数校验异常：%s");
//        }
//        return Result.success();
//    }


    /**
     * 全局变量设置测试
     *
     */
    // TODO 全局测试
//    @PostMapping("/global")
//    public Result globalRun(@RequestBody SetFangZhenMoNiDTO setFangZhenMoNi) throws IOException {
//        //model文件的复制
//        String pipsPath = PipesimUtil.createPips(modelPath);
//        String pipsFilePath = pipsPath.replace("\\", "/");//复制的pips文件路径的修改  把 \ 改为 /
//
//        SetFangZhenMoNiDTO setFangZhenMoNiDTO = setFangZhenMoNi;
//        Integer fzmnwj = setFangZhenMoNiDTO.getSimulationidSim();//仿真模拟结果表外键
//        List<SimSettingDTO> simSettingList = setFangZhenMoNiDTO.getSimsettinglist();//全局设置属性集合
//        List<ElementPropertyDTO> elementPropertyList = setFangZhenMoNiDTO.getElementpropertylist();//批量更新参数集合
//
//        //TODO 实时模拟时间总表
////        RealtimesimResultTbl realtimesimResultTbl = new RealtimesimResultTbl();
////        realtimesimResultTbl.setSimulationidRealsim(123);//实时模拟表Id
////        realtimesimResultTbl.setRealtimeSim(new Date());//实时模拟的时间
////        pipesimService.insertShiShiMoNi(realtimesimResultTbl);//把数据插入到实时仿真结果总表中
//
//        String pyFilePath = PipesimUtil.createPyFile();//生成Python文件
//        PrintStream printStream = null;//打印流
//        try {
//            printStream = new PrintStream(new FileOutputStream(pyFilePath));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        //TODO 全局设置
//        String[][] heat = new String[0][];
//        String[][] sim = new String[0][];
//        String[][] flow = new String[0][];
//        if (simSettingList.size() >= 0 && simSettingList != null) {
//            List list = PipesimUtil.simSettingChuLi(simSettingList);
//            for (int i = 0; i < list.size(); i++) {
//                switch (i) {
//                    case 0:
//                        flow = (String[][]) list.get(i);
//                        break;
//                    case 1:
//                        heat = (String[][]) list.get(i);
//                        break;
//                    case 2:
//                        sim = (String[][]) list.get(i);
//                        break;
//                }
//            }
//        }
//        //TODO 批量更新
//        List propertyValues = new ArrayList();//设备属性值集合
//        List elementNames = new ArrayList();//设备名称集合
//        List propertyKeys = new ArrayList();//设备属性集合
//        for (int i = 0; i < elementPropertyList.size(); i++) {
//            Double propertyValue = elementPropertyList.get(i).getPropertyvalue();//设备属性值
//            if (propertyValue != null) {
//                propertyValues.add(propertyValue);
//                String elementName = elementPropertyList.get(i).getElementname();//设备名称
//                elementNames.add(elementName);
//                String propertyKey = elementPropertyList.get(i).getPropertykey();//设备属性
//                propertyKeys.add(propertyKey);
//            }
//        }
//        String[][] batchUpdate = new String[propertyValues.size()][3];
//        for (int i = 0; i < propertyValues.size(); i++) {
//            Double propertyValue = (Double) propertyValues.get(i);
//            String propertyKey = (String) propertyKeys.get(i);
//            String elementName = (String) elementNames.get(i);
//            batchUpdate[i][0] = elementName;
//            batchUpdate[i][1] = propertyKey;
//            if (propertyKey.equals("Parameters.Source.TEMPERATURE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.wddegcTodegf(propertyValue));
//            } else if (propertyKey.equals("Parameters.Source.PRESSURE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.ylmpaTopsia(propertyValue));
//            } else if (propertyKey.equals("Parameters.Source.GASFLOWRATE")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.lsmsTomscfd(propertyValue));
//            } else if (propertyKey.equals("Parameters.Flowline.INNERDIAMETER")) {
//                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.mToIn(propertyValue));
//            } else {
//                batchUpdate[i][2] = String.valueOf(propertyValue);
//            }
//        }
//        String open = pipesimService.open(pipsFilePath);//仿真模拟方案表编号
//        String update = pipesimService.update(batchUpdate);
//        String globalHeat = pipesimService.setGlobalHeat(heat);
//        String setting = pipesimService.setSimSetting(sim);
//        String globalFlow = pipesimService.setGlobalFlow(flow);
//        String save = pipesimService.save(pipsFilePath);
//        String branch = pipesimService.resultBranch();
//        String node = pipesimService.resultNode();
//        String close = pipesimService.close();
//        String concect = (open + setting + globalFlow + globalHeat + update + save + branch + node + close);
//        printStream.println(concect);
//        printStream.close();
//        String outputResult = PipesimUtil.outputResult(variableUrl, pyFilePath);
//        if (outputResult == null) {
//            return Result.build(500101, "参数校验异常：%s");
//        }
//        return Result.success();
//    }


    /**
     * 获取节点实时模拟结果测试
     * @return
     */
//    @ResponseBody
//    @RequestMapping(value = "/test2", method = RequestMethod.POST)
//    public Object getNodeFzjg() throws ParseException {
//        List<ElementName> elementNameList = new ArrayList<>();
//        elementNameList.add(new ElementName("P203J"));
//        elementNameList.add(new ElementName("P102"));
//        elementNameList.add(new ElementName("3-29"));
//        elementNameList.add(new ElementName("P302"));
//
//        //TODO 最后十条实时节点数据测试
//        List<RealtimesimNodeResultTbl> realtimeSimulationIdList = pipesimService.selectSimulationidEndTen();
//        List node1 = new ArrayList<>();
//        for (int i = 0; i < realtimeSimulationIdList.size(); i++) {
//            Integer simulationId = realtimeSimulationIdList.get(i).getSimulationidRealsimall();
//            Date realtime = pipesimService.selectRealtimeById(simulationId);
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//            String s = sdf.format(realtime);
//            Date date = sdf.parse(s);
//
//            List<NodeProperty> node = new ArrayList<>();
//            for (int j = 0; j < elementNameList.size(); j++) {
//                String elementname = elementNameList.get(j).getElementname();
//                RealtimesimNodeResultTbl nodeRealtimeData = pipesimService.selectDataByNode(simulationId, elementname);//根据实时仿真方案id和节点名称查询节点数据
//                Double flow = nodeRealtimeData.getFlowRealsimnoderes();//流量
//                Double pressure = nodeRealtimeData.getPressureRealsimnoderes();//压力
//                Double temperature = nodeRealtimeData.getTemperatureRealsimnoderes();//温度
//                String elementid = nodeRealtimeData.getElementidRealsimnoderes();//设备编号
//                NodeProperty nodeProperty = new NodeProperty();
//                nodeProperty.setElementidRealsimnoderes(elementid);
//                nodeProperty.setElementnameRealsimnoderes(elementname);
//                nodeProperty.setFlowRealsimnoderes(flow);
//                nodeProperty.setPressureRealsimnoderes(pressure);
//                nodeProperty.setTemperatureRealsimnoderes(temperature);
//                node.add(nodeProperty);
//            }
//            node1.add(new NodeData(date, node));
//        }
////        //TODO 实时节点数据测试
////        Integer simulationid = 79;
////        NodeData nodeData = new NodeData();
////        List<NodeProperty> node =  new ArrayList<>();//list集合存放属性值
////        for (int i = 0; i < elementNameList.size(); i++) {
////            String elementname = elementNameList.get(i).getElementname();//节点名称
////            RealtimesimNodeResultTbl nodeRealtimeData = pipesimService.selectDataByNode(simulationid,elementname);//根据实时仿真方案id和节点名称查询节点数据
////            Double flow = nodeRealtimeData.getFlowRealsimnoderes();//流量
////            Double pressure = nodeRealtimeData.getPressureRealsimnoderes();//压力
////            Double temperature = nodeRealtimeData.getTemperatureRealsimnoderes();//温度
////            String id = nodeRealtimeData.getElementidRealsimnoderes();//设备编号
////            NodeProperty nodeProperty = new NodeProperty();
////            nodeProperty.setElementidRealsimnoderes(id);
////            nodeProperty.setElementnameRealsimnoderes(elementname);
////            nodeProperty.setFlowRealsimnoderes(flow);
////            nodeProperty.setPressureRealsimnoderes(pressure);
////            nodeProperty.setTemperatureRealsimnoderes(temperature);
////            node.add(nodeProperty);
////        }
//////        nodeData.setRealtime(realtime);//实时时间
////        nodeData.setElementlist(node);//节点数据
//
//        return node1;
//    }
}
