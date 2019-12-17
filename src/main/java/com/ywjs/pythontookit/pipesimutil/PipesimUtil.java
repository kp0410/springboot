package com.ywjs.pythontookit.pipesimutil;

import com.ywjs.model.dto.ElementPropertyDTO;
import com.ywjs.model.dto.SimSettingDTO;
import com.ywjs.model.entity.SimeleNodeResultTbl;
import com.ywjs.model.entity.SimelePipeResultTbl;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class PipesimUtil {

    //当前项目路径
    public final static String path = System.getProperty("user.dir");
    //删除自动生成的py文件路径
    public final static String DELETEPY = path + "\\createfile\\pyfile";
    //删除自动生成的pips文件路径
    public final static String DELETEPIPS = path + "\\createfile\\pipsfile";
//     + (new SimpleDateFormat("yyyy-MM-dd")).format(new Date(System.currentTimeMillis())) + "\\"
    //py文件的生成路径
    public final static String PYURL = path + "\\createfile\\pyfile\\" ;
    //pips文件的生成路径
    public final static String PIPSURL = path + "\\createfile\\pipsfile\\";

    /**
     * py文件的生成
     * @return 文件路径
     */
    public static String createPyFile() {
//        //py文件名称的命名
//        if (!(new File(PYURL)).exists() && !(new File(PYURL)).isDirectory()) {
//            try {
//                //生成文件夹
//                new File(PYURL).mkdir();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        SimpleDateFormat pyFileName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS");
        String filePath = PYURL + pyFileName.format(new Date(System.currentTimeMillis())) + "-networksim.py";
        return filePath;
    }

    /**
     * pips文件的复制
     * @return 文件路径
     */
    public static String createPips(String filePath) throws IOException {
//        //pips文件名称的命名
//        if (!(new File(PIPSURL)).exists() && !(new File(PIPSURL)).isDirectory()) {
//            try {
//                //生成文件夹
//                new File(PIPSURL).mkdir();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        SimpleDateFormat pyFileName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss-SSS");
        String pipsPath = PIPSURL + pyFileName.format(new Date(System.currentTimeMillis())) + "-model.pips";
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(filePath);
            output = new FileOutputStream(pipsPath);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
        return pipsPath;
    }

    /**
     * 返回结果
     * @param variablePath py环境变量的路径
     * @param pyFilePath py文件的路径
     * @return  结果
     */
    public static String outputResult(String variablePath,String pyFilePath){
        Process proc;
        String result = "";
        try {
            String[] addModel = new String[]{variablePath, pyFilePath};
            proc = Runtime.getRuntime().exec(addModel);
            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 打开操作
     * @param filePath model的文件路径
     * @return
     */
    public static String open(String filePath){
        String open = "import sys\n" +
                "import io\n" +
                "sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding='utf-8')\n" +
                "from sixgill.pipesim import Model\n" +
                "from sixgill.definitions import ALL,ModelComponents, Parameters, Constants\n" +
                "from sixgill.definitions import SystemVariables, ProfileVariables\n" +
                "from collections import defaultdict\n" +
                "import pandas as pd\n" +
                "import os.path\n" +
                "filename = os.path.join(os.path.dirname(__file__), \"" + filePath + "\")\n" +
                "model = Model.open(filename)\n"+
                "profile_variables = [\n" +
                "           ProfileVariables.TEMPERATURE,\n" +
                "           ProfileVariables.ELEVATION,\n" +
                "           ProfileVariables.HOLDUP_FRACTION_LIQUID,\n" +
                "           ProfileVariables.PRESSURE,\n" +
                "           ProfileVariables.TOTAL_DISTANCE,\n" +
                "           ProfileVariables.MEAN_VELOCITY_FLUID,\n" +
                "           ProfileVariables.HEAT_CAPACITY_GAS_INSITU,\n" +
                "           ProfileVariables.HEAT_CAPACITY_LIQUID_INSITU,\n" +
                "           ProfileVariables.DENSITY_GAS_INSITU,\n" +
                "           ProfileVariables.DENSITY_LIQUID_INSITU,\n" +
                "           ProfileVariables.FLOWRATE_GAS_INSITU,\n" +
                "]\n"+
                "system_variables = [\n" +
                "            SystemVariables.PRESSURE,\n" +
                "            SystemVariables.TEMPERATURE,\n" +
                "            SystemVariables.VOLUME_FLOWRATE_GAS_STOCKTANK,\n" +
                "]\n";
        return open;
    }

    /**
     * 批量更新数据的操作
     * @param componentName
     * @param paramenterName
     * @param paramentValue
     * @return
     */
    public static String batchUpdate(String[] componentName, String[] paramenterName, String[] paramentValue){
        String update = "with model.batch_update():\n"+
                "   values = defaultdict(dict)\n";
        for (int i = 0; i < paramentValue.length; i++) {
            String updateContect = "   values['"+componentName[i]+"']["+paramenterName[i]+"] = "+paramentValue[i]+"\n";
            update += updateContect;
        }
        String uc = "   model.set_values(values)\n";
        update += uc;
        return update;
    }

    /**
     * 全局设置的操作
     * @param equationName
     * @param value
     * @return
     */
    public static String setSimSetting(String[] equationName,String[] value){
        String simulation = "sim_settings = model.sim_settings\n";
        for (int i = 0; i < equationName.length; i++) {
            String sim ="sim_settings[" + equationName[i] + "] = " + value[i] + "\n";
            simulation += sim;
        }
        return simulation;
    }

    /**
     * 返回管道数据的操作
     * @return
     */
    public static String resultBranch(){
        String resultsBranch =
                "for branch,profile in results.profile.items():\n" +
                        "    profile_df = pd.DataFrame.from_dict(profile)\n" +
                        "    print(format(branch))\n" +
                        "    print(\"!Elevation:\",profile_df['Elevation'].tolist())\n" +
                        "    print(\"!Pressure:\",profile_df['Pressure'].tolist())\n" +
                        "    print(\"!Temperature:\",profile_df['Temperature'].tolist())\n" +
                        "    print(\"!HoldupFractionLiquid:\",profile_df['HoldupFractionLiquid'].tolist())\n" +
                        "    print(\"!TotalDistance,:\",profile_df['TotalDistance'].tolist())\n" +
                        "    print(\"!BranchEquipment:\",profile_df['BranchEquipment'].tolist())\n" +
                        "    print(\"!MeanVelocityFluid:\",profile_df['MeanVelocityFluid'].tolist())\n" +
                        "    print(\"!FlowrateGasInSitu:\",profile_df['FlowrateGasInSitu'].tolist())\n" +
                        "    print(\"!HeatCapacityGasInSitu:\",profile_df['HeatCapacityGasInSitu'].tolist())\n" +
                        "    print(\"!HeatCapacityLiquidInSitu:\",profile_df['HeatCapacityLiquidInSitu'].tolist())\n" +
                        "    print(\"!DensityGasInSitu:\",profile_df['DensityGasInSitu'].tolist())\n" +
                        "    print(\"!DensityLiquidInSitu:\",profile_df['DensityLiquidInSitu'].tolist())\n" +
                        "    print(\";\")\n" +
                        "print(\"&\")\n";
        return resultsBranch;
    }

    /**
     *  保存的操作
     * @param filePath
     * @return
     */
    public static String save(String filePath){
        String save = "model.save(\""+filePath+"\")\n" +
                "model.tasks.networksimulation.reset_conditions()\n"+
                "results =  model.tasks.networksimulation.run(system_variables=system_variables,profile_variables=profile_variables)\n";
        return save;
    }

    /**
     * 返回节点数据的操作
     * @return
     */
    public static String resultNode(){
        String resultsNode ="param=['Pressure','Temperature','VolumeFlowrateGasStockTank']\n" +
                "new_array = [key for key in results.node[\"Pressure\"]]\n" +
                "for key in param:\n" +
                "    print(key+\"!\")\n" +
                "    for keykey in new_array:\n" +
                "        print(\"{}#{}:\".format(keykey,results.node[key][keykey]))\n" +
                "    print(\";\")\n";
        return resultsNode;
    }

    /**
     * 关闭model的操作
     * @return
     */
    public static String close(){
        String close = "model.close()\n";
        return close;
    }

    /**
     * 获取当前的仿真设置
     * @return
     */
    public static String getSimSetting(){
        String simData = "sim_settings = model.sim_settings\n" +
                "for k, v in sim_settings.items():\n" +
                "    print ( \"参数: {} , 参数值: {}\".format(k, v)+\";\")\n";
        return simData;
    }

    /**
     * 管道数据的处理
     * @param branchData  返回的管道数据
     */
    public static List<SimelePipeResultTbl> branchDataChuLi(String branchData) {
        List<SimelePipeResultTbl> simelePipeResultTblList = new ArrayList<>();
        String[] split = branchData.split(";");
        String branchname = null;
        String holdupFractionLiquidValues = null;
        String totaldistanceValues = null;
        String equipmentValues = null;
        String flowVelocities = null;
        String gasFlowrates = null;
        String gasHeats = null;
        String liquidHeats = null;
        String gasDensitys = null;
        String liquidDensitys = null;
        String elevationValues = null;
        String temperatureValues = null;
        String pressureValues = null;
        SimelePipeResultTbl simelePipeResultTbl;
        for (int i = 0; i < split.length; i++) {
            split[i].split("!");
            for (int j = 0; j < split[i].split("!").length; j++) {
                switch (j) {
                    case 0:
                        branchname = split[i].split("!")[j];//管道名称
                        break;
                    case 1:
                        elevationValues = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//高程
                        break;
                    case 2:
                        pressureValues = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//压力
                        break;
                    case 3:
                        temperatureValues = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//温度
                        break;
                    case 4:
                        holdupFractionLiquidValues = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//持液率
                        break;
                    case 5:
                        totaldistanceValues = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//里程
                        break;
                    case 6:
                        equipmentValues = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "").replace("'", "");//设备名称
                        break;
                    case 7:
                        flowVelocities = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//流速
                        break;
                    case 8:
                        gasFlowrates = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//气体流量
                        break;
                    case 9:
                        gasHeats = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//气体比热
                        break;
                    case 10:
                        liquidHeats = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//液体比热
                        break;
                    case 11:
                        gasDensitys = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//气体密度
                        break;
                    case 12:
                        liquidDensitys = ((split[i].split("!"))[j]).split(":")[1].replace("[", "").replace("]", "");//液体密度
                        break;
                }
            }
            String[] split6 = equipmentValues.split(",");//设备名称
            String[] split5 = totaldistanceValues.split(",");//里程
            String[] split4 = holdupFractionLiquidValues.split(",");//持液率
            String[] split3 = temperatureValues.split(",");//温度
            String[] split2 = pressureValues.split(",");//压力
            String[] split1 = elevationValues.split(",");//高程
            String[] flowvelocity = flowVelocities.split(",");//流速
            String[] gasFlowrate = gasFlowrates.split(",");//气体流量
            String[] gasHeat = gasHeats.split(",");//气体比热
            String[] liquidHeat = liquidHeats.split(",");//液体比热
            String[] gasDensity = gasDensitys.split(",");//气体密度
            String[] liquidDensity = liquidDensitys.split(",");//液体密度
            for (int k = 0; k < split5.length; k++) {
                simelePipeResultTbl = new SimelePipeResultTbl();
                String a = " nan";
                String hflvs = split4[k].toString();//持液率
                if (!hflvs.equals(a)) {
                    Double hflv = Double.parseDouble(hflvs.replaceFirst(" ", ""));//持液率
                    simelePipeResultTbl.setLiquidSimpiperes(hflv);
                }
                //从管道名称中获取设备名称
                if (k == 0 && split6[k].equals(" None")) {
                    split6[k] = branchname;
                } else if (k == 0) {
                    branchname = split6[k].replaceFirst(" ", ""); //设备名称
                } else if (split6[k].equals(" None")) {
                    split6[k] = branchname;
                } else if (!split6[k].equals(" None")) {
                    branchname = split6[k];
                }
                String totalValues = split5[k].toString();//里程
                Double total = PipesimConversionUnit.ftToM(Double.parseDouble(totalValues.replaceFirst(" ","")));
                String temperatures = split3[k].toString();//温度
                Double temperature = PipesimConversionUnit.wddegfTodegc(Double.parseDouble(temperatures.replaceFirst(" ","")));
                String pressures = split2[k].toString();//压力
                Double pressure = PipesimConversionUnit.ylpisaTompa(Double.parseDouble(pressures.replaceFirst(" ","")));
                String elevations = split1[k].toString();//高程
                Double elevation =PipesimConversionUnit.ftToM(Double.parseDouble(elevations.replaceFirst(" ","")));
                String flowvelos = flowvelocity[k].toString();//流速
                if (!flowvelos.equals(a)) {
                    Double flowvelo = PipesimConversionUnit.ftToM(Double.parseDouble(flowvelos.replaceFirst(" ","")));
                    simelePipeResultTbl.setFlowSimpiperes(flowvelo);//流速
                }
                String gasflowrates = gasFlowrate[k].toString();//气体流量
                Double gasflowrate = PipesimConversionUnit.lsmscfdToms(Double.valueOf(gasflowrates.replaceFirst(" ", "")));
                String gasheats = gasHeat[k].toString();//气体比热
                Double gasheat = PipesimConversionUnit.bireBtuToJ(Double.valueOf(gasheats.replaceFirst(" ", "")));
                String liquidheats = liquidHeat[k].toString();//液体比热
                Double liquidheat = PipesimConversionUnit.bireBtuToJ(Double.valueOf(liquidheats.replaceFirst(" ", "")));

                String gasdensitys = gasDensity[k].toString();//气体密度
                Double gasdensity = PipesimConversionUnit.miduLbftToKgm(Double.valueOf(gasdensitys.replaceFirst(" ", "")));

                String liquiddensitys = liquidDensity[k].toString();//液体密度
                Double liquiddensity = PipesimConversionUnit.miduLbftToKgm(Double.valueOf(liquiddensitys.replaceFirst(" ", "")));
                simelePipeResultTbl.setPipeidSimpiperes(branchname);//管道编号
                simelePipeResultTbl.setPipenameSimpiperes(branchname);//管道名称
                simelePipeResultTbl.setMileageSimpiperes(total);//里程
                simelePipeResultTbl.setTemperatureSimpiperes(temperature);//温度
                simelePipeResultTbl.setPressureSimpiperes(pressure);//压力
                simelePipeResultTbl.setElevationSimpiperes(elevation);//高程
                simelePipeResultTbl.setFlowrateSimpiperes(gasflowrate);//气体流量
                simelePipeResultTbl.setGasheatSimpiperes(gasheat);//气体比热
                simelePipeResultTbl.setLiquidheatSimpiperes(liquidheat);//液体比热
                simelePipeResultTbl.setGasdensitySimpiperes(gasdensity);//气体密度
                simelePipeResultTbl.setLiquiddensitySimpiperes(liquiddensity);//液体密度
                simelePipeResultTblList.add(simelePipeResultTbl);
            }
        }
        return simelePipeResultTblList;
    }

    /**
     * 节点数据的处理
     * @param nodeData  返回的节点数据
     */
    public static List<SimeleNodeResultTbl> nodeDataChuLi(String nodeData){
        List<SimeleNodeResultTbl> simeleNodeResultTblList = new ArrayList<>();
        String[] nodes = nodeData.split(";");//以属性名分为数组
        String[] yali = nodes[0].split(":");//压力数组
        String[] wendu = nodes[1].split(":");//温度数组
        String[] liushu = nodes[2].split(":");//流速数组
        SimeleNodeResultTbl simeleNodeResultTbl;
        for (int i = 1; i < yali.length; i++) {
            simeleNodeResultTbl = new SimeleNodeResultTbl();
            String nodeName = yali[i].split("#")[0];//设备名称
            String[] ylv = yali[i].split("#");//压力值
            String[] wdv = wendu[i].split("#");//温度值
            String[] llv = liushu[i].split("#");//流速值
            Double pressure = PipesimConversionUnit.ylpisaTompa(Double.parseDouble(ylv[1]));//单位转换psia 转为Mpa
            Double temperature = PipesimConversionUnit.wddegfTodegc(Double.parseDouble(wdv[1]));//单位转换 华氏温度转为摄氏度
            Double flowrate = PipesimConversionUnit.lsmscfdToms(Double.parseDouble(llv[1]));//单位转换 MMcfd 转为m³/s
            simeleNodeResultTbl.setElementnameSimnoderes(nodeName);
            simeleNodeResultTbl.setElementidSimnoderes(nodeName);
            simeleNodeResultTbl.setPressureSimpiperes(pressure);
            simeleNodeResultTbl.setTemperatureSimnoderes(temperature);
            simeleNodeResultTbl.setFlowRealsimnoderes(flowrate);
            simeleNodeResultTblList.add(simeleNodeResultTbl);
        }
        return simeleNodeResultTblList;
    }

    /**
     *  设置模型设置的全局全球流关联
     *  更新全局全球流关联
     * @param attributeName  属性名
     * @param attributeValue 属性值
     * @return
     */
    public static String setGlobalFlowCorrelation(String[] attributeName,String[] attributeValue){
        String globalFlowCorrealation = "model.sim_settings.global_flow_correlation({\n";
        for (int i = 0; i < attributeName.length ; i++) {
            String gfc = "  "+attributeName[i]+": "+attributeValue[i]+",\n";
            globalFlowCorrealation += gfc;
        }
        String end = "})\n";
        globalFlowCorrealation += end;
        return globalFlowCorrealation;
    }

    /**
     * 设置模型设置的全局传热选项
     * 更新全球传热
     * @param attributeName
     * @param attributeValue
     * @return
     */
    public static String setGlobalHeatTransfer(String[] attributeName,String[] attributeValue){
        String globalHeatTransfer = "model.sim_settings.global_heat_transfer_option({\n";
        for (int i = 0; i < attributeName.length; i++) {
            String ght = "  "+ attributeName[i] +": "+ attributeValue[i] +",\n";
            globalHeatTransfer += ght;
        }
        String end = "})\n";
        globalHeatTransfer += end;
        return globalHeatTransfer;
    }

    /**
     * 全局设置参数的处理
     * @param simSettingList
     * @return
     */
    public static List simSettingChuLi(List<SimSettingDTO> simSettingList) {
        //IdentityHashMap 解决属性名相同的问题
        IdentityHashMap<String,String> flowMap = new IdentityHashMap<String,String>();//全局全球流关联
        IdentityHashMap<String,String> heatMap = new IdentityHashMap<String,String>();//全局全球传热
        IdentityHashMap<String,String> simMap = new IdentityHashMap<String,String>();//全局模型设置
        for (int i = 0; i < simSettingList.size(); i++) {
            String ssname = simSettingList.get(i).getKey();//属性名称
            String ssvalue = simSettingList.get(i).getValue();//属性值
            if (ssname.contains("Parameters.FlowCorrelation")) {
                flowMap.put(ssname, ssvalue);
            } else if (ssname.contains("Parameters.HeatTransferOption")) {
                heatMap.put(ssname, ssvalue);
            } else {
                simMap.put(ssname,ssvalue);
            }
        }
        //从map集合中取出数据转换为二维数组
        List simSetting = new ArrayList();
        if (flowMap!=null) {
            int a = 0;
            String[][] flow = new String[flowMap.size()][2];
            for (Object flowName : flowMap.keySet()) {
                String flowValue = (String) flowMap.get(flowName);
                flow[a][0] = (String) flowName;
                flow[a][1] = flowValue;
                a++;
            }
            simSetting.addAll(Collections.singleton(flow));//把数组加入到list集合中
        }
        if (heatMap!=null) {
            int a = 0;
            String[][] heat = new String[heatMap.size()][2];//全局全球传热数组
            for (Object heatName : heatMap.keySet()) {
                String heatValue = (String) heatMap.get(heatName);
                heat[a][0] = (String) heatName;
                heat[a][1] = heatValue;
                a++;
            }
            simSetting.addAll(Collections.singleton(heat));//把数组加入到list集合中
        }
        if (simMap!=null) {
            int a = 0;
            String[][] sim = new String[simMap.size()][2];//全局模型设置数组
            for (Object simName : simMap.keySet()) {
                String simValue = (String) simMap.get(simName);
                sim[a][0] = (String) simName;
                sim[a][1] = simValue;
                a++;
            }
            simSetting.addAll(Collections.singleton(sim));//把数组加入到list集合中
        }
        return simSetting;
    }


    /**
     * 批量更新数据处理
     * @param elementPropertyList
     * @return
     */
    public static String[][] updateDataListChuLi(List<ElementPropertyDTO> elementPropertyList) {
        List propertyValues = new ArrayList();//设备属性值集合
        List elementNames = new ArrayList();//设备名称集合
        List propertyKeys = new ArrayList();//设备属性集合
        for (int i = 0; i < elementPropertyList.size(); i++) {
            Double propertyValue = elementPropertyList.get(i).getPropertyvalue();//设备属性值
            String propertykey = elementPropertyList.get(i).getPropertykey();//设备属性
            if (propertykey.equals("Parameters.Source.PRESSURE")){
                continue;
            }else if (propertyValue != null) {
                propertyValues.add(propertyValue);
                String elementName = elementPropertyList.get(i).getElementname();//设备名称
                elementNames.add(elementName);
                String propertyKey = elementPropertyList.get(i).getPropertykey();//设备属性
                propertyKeys.add(propertyKey);
            }
        }
        String[][] batchUpdate = new String[propertyValues.size()][3];
        for (int i = 0; i <propertyValues.size() ; i++) {
            Double propertyValue = (Double) propertyValues.get(i);
            String propertyKey = (String) propertyKeys.get(i);
            String elementName = (String) elementNames.get(i);
            batchUpdate[i][0] = elementName;
            batchUpdate[i][1] = propertyKey;
            if (propertyKey.equals("Parameters.Source.TEMPERATURE")) {
                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.wddegcTodegf(propertyValue));
            } else if (propertyKey.equals("Parameters.Source.PRESSURE")) {
                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.ylmpaTopsia(propertyValue));
            } else if (propertyKey.equals("Parameters.Source.GASFLOWRATE")) {
                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.lsmsTomscfd(propertyValue));
            } else if (propertyKey.equals("Parameters.Flowline.INNERDIAMETER")){
                batchUpdate[i][2] = String.valueOf(PipesimConversionUnit.mToIn(propertyValue));
            }else {
                batchUpdate[i][2] = String.valueOf(propertyValue);
            }
        }
        return batchUpdate;
    }

    /**
     * 删除30分钟前生成的文件(包括py文件和pips文件)
     */
    public static void deleteCreateFiles() {
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
    }
}



