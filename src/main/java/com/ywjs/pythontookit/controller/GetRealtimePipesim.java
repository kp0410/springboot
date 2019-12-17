package com.ywjs.pythontookit.controller;

import com.ywjs.common.vo.Result;
import com.ywjs.model.dto.*;
import com.ywjs.model.entity.*;
import com.ywjs.model.vo.SetRealTime;
import com.ywjs.pythontookit.pipesimutil.PipesimConversionUnit;
import com.ywjs.pythontookit.pipesimutil.PipesimUtil;
import com.ywjs.pythontookit.service.PipesimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@RestController
public class GetRealtimePipesim {
    @Autowired
    PipesimService pipesimService;
//    @Autowired
//    TimingService timingService;

    @Value("${pips.python.variableurl}")
    private String variableUrl;
    @Value("${pips.model.url}")
    private String modelPath;

    /**
     * 实时仿真模拟计算
     * @param setRealTiemFzmnDTO
     * @throws IOException
     */
    @RequestMapping("/test")
    public Result setrealtiemfzmn(SetRealTime setRealTiemFzmnDTO) throws IOException {
        //model文件的复制
        String pipsPath = PipesimUtil.createPips(modelPath);
        String pipsFilePath = pipsPath.replace("\\", "/");//复制的pips文件路径的修改  把 \ 改为 /
        //TODO 全局设置属性集合
        List<SimSettingDTO> simSettingList = setRealTiemFzmnDTO.getSimsettinglist();
        //批量更新数据集合
        List<ElementPropertyDTO> elementpropertylist = setRealTiemFzmnDTO.getElementpropertylist();

        String pyFilePath = PipesimUtil.createPyFile();//生成Python文件
        PrintStream printStream = null;//打印流
        try {
            printStream = new PrintStream(new FileOutputStream(pyFilePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //TODO 全局设置
        String[][] heat = new String[0][];//全球传热
        String[][] sim = new String[0][];//全局设置
        String[][] flow = new String[0][];//全局全球流关联
        if (simSettingList.size() >= 0 && simSettingList != null) {
            List list = PipesimUtil.simSettingChuLi(simSettingList);
            for (int i = 0; i < list.size(); i++) {
                switch (i) {
                    case 0:
                        flow = (String[][]) list.get(i);
                        break;
                    case 1:
                        heat = (String[][]) list.get(i);
                        break;
                    case 2:
                        sim = (String[][]) list.get(i);
                        break;
                }
            }
        }
        String[][] batchUpdate = PipesimUtil.updateDataListChuLi(elementpropertylist);// 批量更新
        String open = pipesimService.open(pipsFilePath);//复制的pips文件路径
        String update = pipesimService.update(batchUpdate);//批量更新
        String globalHeat = pipesimService.setGlobalHeat(heat);//全球传热
        String setting = pipesimService.setSimSetting(sim);//全局设置
        String globalFlow = pipesimService.setGlobalFlow(flow);//全局全球流关联
        String save = pipesimService.save(pipsFilePath);//保存
        String branch = pipesimService.resultBranch();//管道结果的返回
        String node = pipesimService.resultNode();//节点结果的返回
        String close = pipesimService.close();//pips文件的关闭
        String concect = (open + setting + globalFlow + globalHeat + update + save + branch + node + close);
        printStream.println(concect);
        printStream.close();
        //删除30分钟前生成的文件
        PipesimUtil.deleteCreateFiles();
        String outputResult = PipesimUtil.outputResult(variableUrl, pyFilePath);
        System.out.println(outputResult);
        if (outputResult.isEmpty()) {
            return Result.build(500101, "参数校验异常：%s");
        }else {
            //实时仿真结果总表
            RealtimesimResultTbl realtimesimResultTbl = new RealtimesimResultTbl();
            //TODO 实时仿真结果总表的实时仿真模拟表id
            realtimesimResultTbl.setSimulationidRealsim(setRealTiemFzmnDTO.getRealtimeSimid());//实时模拟表Id
            realtimesimResultTbl.setRealtimeSim(new Date());//实时模拟的时间
            pipesimService.insertShiShiMoNi(realtimesimResultTbl);//把数据插入到实时仿真结果总表中
            Long simulationidRealsimall = realtimesimResultTbl.getSimulationidRealsimall();//获取实时仿真结果总表的自增id
            //返回数据的处理
            String[] data = outputResult.split("&");
            String branchdata = data[0];//管道数据
            String nodedata = data[1];//节点数据
            //插入实时仿真模拟表节点数据
            List<SimeleNodeResultTbl> simeleNodeResultTblList = PipesimUtil.nodeDataChuLi(nodedata);//节点数据的处理及返回节点数据的list集合
            RealtimesimNodeResultTbl realtimesimNodeResultTbl = new RealtimesimNodeResultTbl();
            //从list集合中取出对应的值并插入数据库
            for (int i = 0; i < simeleNodeResultTblList.size(); i++) {
                realtimesimNodeResultTbl.setSimulationidRealsimall(simulationidRealsimall.intValue());//仿真模拟方案表编号
                realtimesimNodeResultTbl.setFlowRealsimnoderes(simeleNodeResultTblList.get(i).getFlowRealsimnoderes());//流量
                realtimesimNodeResultTbl.setTemperatureRealsimnoderes(simeleNodeResultTblList.get(i).getTemperatureSimnoderes());//温度
                realtimesimNodeResultTbl.setPressureRealsimnoderes(simeleNodeResultTblList.get(i).getPressureSimpiperes());//压力
                realtimesimNodeResultTbl.setElementnameRealsimnoderes(simeleNodeResultTblList.get(i).getElementnameSimnoderes());//设备名称
                realtimesimNodeResultTbl.setElementidRealsimnoderes(simeleNodeResultTblList.get(i).getElementidSimnoderes());//设备编号
                pipesimService.insertRealtimeNode(realtimesimNodeResultTbl);
            }
            //插入实时仿真模拟表管道数据
            List<SimelePipeResultTbl> simelePipeResultTbls = PipesimUtil.branchDataChuLi(branchdata);//管道数据的处理及返回节点数据的list集合
            RealtimesimPipeResultTbl realtimesimPipeResultTbl = new RealtimesimPipeResultTbl();
            //从list集合中取出对应的值并插入数据库
            for (int i = 0; i < simelePipeResultTbls.size(); i++) {
                realtimesimPipeResultTbl.setSimulationidRealsimall(simulationidRealsimall.intValue());//仿真模拟方案表编号
                realtimesimPipeResultTbl.setPipeidSimpiperes(simelePipeResultTbls.get(i).getPipeidSimpiperes());//管道编号
                realtimesimPipeResultTbl.setLiquidSimpiperes(simelePipeResultTbls.get(i).getLiquidSimpiperes());//持液率
                realtimesimPipeResultTbl.setFlowSimpiperes(simelePipeResultTbls.get(i).getFlowSimpiperes());//流速
                realtimesimPipeResultTbl.setPipenameSimpiperes(simelePipeResultTbls.get(i).getPipenameSimpiperes());//管道名称
                realtimesimPipeResultTbl.setMileageSimpiperes(simelePipeResultTbls.get(i).getMileageSimpiperes());//里程
                realtimesimPipeResultTbl.setTemperatureSimpiperes(simelePipeResultTbls.get(i).getTemperatureSimpiperes());//温度
                realtimesimPipeResultTbl.setPressureSimpiperes(simelePipeResultTbls.get(i).getPressureSimpiperes());//压力
                realtimesimPipeResultTbl.setElevationSimpiperes(simelePipeResultTbls.get(i).getElevationSimpiperes());//高程
                realtimesimPipeResultTbl.setFlowrateSimpiperes(simelePipeResultTbls.get(i).getFlowrateSimpiperes());//气体流量
                realtimesimPipeResultTbl.setGasheatSimpiperes(simelePipeResultTbls.get(i).getGasheatSimpiperes());//气体比热
                realtimesimPipeResultTbl.setLiquidheatSimpiperes(simelePipeResultTbls.get(i).getLiquidheatSimpiperes());//流体比热
                realtimesimPipeResultTbl.setGasdensitySimpiperes(simelePipeResultTbls.get(i).getGasdensitySimpiperes());//气体密度
                realtimesimPipeResultTbl.setLiquiddensitySimpiperes(simelePipeResultTbls.get(i).getLiquiddensitySimpiperes());//流体密度
                pipesimService.insertRealtimeBranch(realtimesimPipeResultTbl);
            }
            return Result.success();
        }
    }

}
