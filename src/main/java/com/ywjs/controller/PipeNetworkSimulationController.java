/** 
 * @file: PipeNetworkSimulationController.java 
 * @Package： com.ywjs.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月26日 上午10:27:07 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */
package com.ywjs.controller;

import com.ywjs.model.dto.*;
import com.ywjs.model.entity.*;
import com.ywjs.pythontookit.pipesimutil.PipesimConversionUnit;
import com.ywjs.pythontookit.pipesimutil.PipesimUtil;
import com.ywjs.pythontookit.service.PipesimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ywjs.common.vo.Result;
import com.ywjs.service.PipeNetworkSimulationService;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName PipeNetworkSimulationController
 * @Description TODO(管网仿真模拟Controller)
 * @Author 周伟
 * @Date 2019年11月26日 上午10:27:07
 */
@RestController
@RequestMapping("/fzmnfangan")
public class PipeNetworkSimulationController {

    @Autowired
    PipeNetworkSimulationService pipeNetworkSimulationService;
    @Autowired
    PipesimService pipesimService;


    @Value("${pips.python.variableurl}")
    private String variableUrl;
    @Value("${pips.model.url}")
    private String modelPath;


    /**
     *
     * @Description: TODO(获取仿真模拟方案列表)
     * @author： 2019年11月27日  周伟  创建初始版本
     * @param idtypeDTO
     * @return
     */
    @PostMapping("/getSimulationList")
    public Result getSimulationList(@RequestBody IdtypeDTO idtypeDTO){
        Object object = pipeNetworkSimulationService.getSimulationList(idtypeDTO);
        return Result.success(object);
    }

    //仿真模拟计算
    @PostMapping("/setFangZhenMoNi")
    public Result setFangZhenMoNi(@RequestBody SetFangZhenMoNiDTO setFangZhenMoNi) throws IOException {
        //model文件的复制
        String pipsPath = PipesimUtil.createPips(modelPath);
        String pipsFilePath = pipsPath.replace("\\", "/");//复制的pips文件路径的修改  把 \ 改为 /
        SetFangZhenMoNiDTO setFangZhenMoNiDTO =setFangZhenMoNi;
        Integer fzmnwj = setFangZhenMoNiDTO.getSimulationidSim();//仿真模拟结果表外键
        List<SimSettingDTO> simSettingList = setFangZhenMoNiDTO.getSimsettinglist();//全局设置属性集合
        List<ElementPropertyDTO> elementPropertyList = setFangZhenMoNiDTO.getElementpropertylist();//批量更新参数集合
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
        String[][] batchUpdate = PipesimUtil.updateDataListChuLi(elementPropertyList);// 批量更新
        String open = pipesimService.open(pipsFilePath);//仿真模拟方案表编号
        String update = pipesimService.update(batchUpdate);//批量更新
        String globalHeat = pipesimService.setGlobalHeat(heat);//全球传热
        String setting = pipesimService.setSimSetting(sim);//全局设置
        String globalFlow = pipesimService.setGlobalFlow(flow);//全局全球流关联
        String save = pipesimService.save(pipsFilePath);
        String branch = pipesimService.resultBranch();
        String node = pipesimService.resultNode();
        String close = pipesimService.close();
        String concect = (open + setting + globalFlow + globalHeat + update + save + branch + node + close);
        printStream.println(concect);
        printStream.close();

        //删除30分钟前生成的文件
        PipesimUtil.deleteCreateFiles();

        String outputResult = PipesimUtil.outputResult(variableUrl, pyFilePath);
        if (outputResult.isEmpty()){
            return Result.build(500101, "参数校验异常：%s");
        }else {
            //返回数据的处理
            String[] data = outputResult.split("&");
            String branchdata = data[0];//管道数据
            String nodedata = data[1];//节点数据
            //插入仿真模拟实时节点数据
            //把节点数据插入到数据库
            List<SimeleNodeResultTbl> simeleNodeResultTblList = PipesimUtil.nodeDataChuLi(nodedata);//节点数据的处理及返回节点数据的list集合
            SimeleNodeResultTbl simeleNodeResultTbl = new SimeleNodeResultTbl();
            //从list集合中取出对应的值并插入数据库
            for (int i = 0; i <simeleNodeResultTblList.size() ; i++) {
                simeleNodeResultTbl.setSimulationidSim(fzmnwj);//仿真模拟方案表编号
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
                simelePipeResultTbl.setSimulationidRealsim(fzmnwj);//仿真模拟方案表编号
                simelePipeResultTbl.setMileageSimpiperes(simelePipeResultTbls.get(i).getMileageSimpiperes());//里程
                simelePipeResultTbl.setTemperatureSimpiperes(simelePipeResultTbls.get(i).getTemperatureSimpiperes());//温度
                simelePipeResultTbl.setPressureSimpiperes(simelePipeResultTbls.get(i).getPressureSimpiperes());//压力
                simelePipeResultTbl.setElevationSimpiperes(simelePipeResultTbls.get(i).getElevationSimpiperes());//高程
                simelePipeResultTbl.setFlowrateSimpiperes(simelePipeResultTbls.get(i).getFlowrateSimpiperes());//气体流量
                simelePipeResultTbl.setGasheatSimpiperes(simelePipeResultTbls.get(i).getGasheatSimpiperes());//气体比热
                simelePipeResultTbl.setLiquidheatSimpiperes(simelePipeResultTbls.get(i).getLiquidheatSimpiperes());//液体比热
                simelePipeResultTbl.setGasdensitySimpiperes(simelePipeResultTbls.get(i).getGasdensitySimpiperes());//气体密度
                simelePipeResultTbl.setLiquiddensitySimpiperes(simelePipeResultTbls.get(i).getLiquiddensitySimpiperes());//液体密度
                pipesimService.insertbranch(simelePipeResultTbl);
            }
            return Result.success();
        }

    }

    // 5.1.13实时仿真模拟计算
    @PostMapping("/setrealtiemfzmn")
    public Result setrealtiemfzmn(@RequestBody SetRealTiemFzmnDTO setRealTiemFzmnDTO) throws IOException {
        pipeNetworkSimulationService.setrealtiemfzmn(setRealTiemFzmnDTO);
        return Result.success();
    }



}
