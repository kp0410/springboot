/**
 * @file: ReflectUtil.java
 * @Package： com.ywjs.common.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author： 周伟
 * @date： 2019年11月29日 上午11:29:17
 * @version： V1.0
 * @par 版权信息：
 * 2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */
package com.ywjs.common.utils;

import com.ywjs.model.vo.*;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;

/**
 * @ClassName ReflectUtil
 * @Description TODO(这里用一句话描述这个类的作用)
 * @Author 周伟
 * @Date 2019年11月29日 上午11:29:17
 */
public class RealTimeDataUtil {

    public static RealTimeDataUtil build() {
        return new RealTimeDataUtil();
    }

    /**
     * @param map           名称分组后的实时数据
     * @param list          获取到的前端数据集合（站场、井、加热炉）
     * @throws Exception
     * @Description: 遍历解析数据 @author： 2019年11月29日 周伟 创建初始版本
     */
    public static <T, E> void foreachMapAnalysis(Map<String, List<T>> map,  List<E> list)
            throws Exception {
        // 迭代名称分组后的实时数据
        Iterator<Entry<String, List<T>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<T>> entry = iterator.next();
            String ealTimeTargetName = entry.getKey();// 实时数据中名称（站场、井、加热炉）
            String frontName = null; // 前端获取的相关名称（站场、井、加热炉）
            String id = null; // 前端获取的相关编号（站场、井、加热炉）

            if (list.size() == 0) { // 无前端数据，或根据前端数据没查询出数据
                return;
            }
            Class<? extends Object> classe = list.get(0).getClass();
            Field[] Efields = classe.getDeclaredFields();// 获取实体类的所有属性，返回Field数组  

            // 遍历传进来的前端数据列表
            for (E e : list) {
                // 首先获取当前对象e 名称属性（前端数据集合中的）
                for (Field field : Efields) {
                    // 获取属性名
                    String name = field.getName();
                    // 获取bean的某个属性的描述符
                    PropertyDescriptor propDesc = new PropertyDescriptor(name, classe);
                    // 获取读取属性方法
                    Method readMethod = propDesc.getReadMethod();
                    /** 站场的判断 */
                    if ("stationname".equals(name)) { // 获取名称用于与实时数据比较
                        frontName = (String) readMethod.invoke(e);
                    }
                    if ("stationid".equals(name)) { // 获取名称
                        id = (String) readMethod.invoke(e);
                    }
                    /** 井和加热炉的判断 */
                    if ("elementname".equals(name)) { // 获取名称
                        frontName = (String) readMethod.invoke(e);
                    }
                    if ("elementid".equals(name)) { // 获取名称
                        id = (String) readMethod.invoke(e);
                    }
                }
                // 判断前端数据中实时数中名称是否一样，一样则将前端数据集合中的id写入实时数据中
                if (ealTimeTargetName.equalsIgnoreCase(frontName)) {
                    List<T> value = entry.getValue();
                    // 获取实时数据实体属性集
                    Class<? extends Object> classz = value.get(0).getClass();
                    Field[] Tfields = classz.getDeclaredFields();
                    for (Field field : Tfields) {
                        String name = field.getName();// 获取属性名称
                        // 获取bean的某个属性的描述符
                        PropertyDescriptor propDesc = new PropertyDescriptor(name, classz);
                        // 获得用于写入属性值的方法 （setId方法）
                        Method methodSetId = propDesc.getWriteMethod();
                        if ("id".equals(name)) { // 站场id判断
                            // 遍历实时数据集合中的属性，将编号id写入
                            for (T t : value) {
                                methodSetId.invoke(t, id); // 写入属性值
                            }
                            break;
                        }
                        if ("elementid".equals(name)) { // 井，加热炉id
                            // 遍历实时数据集合中的属性，将编号id写入
                            for (T t : value) {
                                methodSetId.invoke(t, id); // 写入属性值
                            }
                            break;
                        }
                    }
                    // 合并list
                    // totalYardList.addAll(entry.getValue());
                }
            }
        }
    }

    /**
     * @param <T>
     * @throws Exception
     * @Description: 遍历YardVO对象中的属性，并封装为RealTimeDataVO对象的集合 @author： 2019年11月29日 周伟 创建初始版本
     */
    public static <T> List<RealTimeDataVO> reflectObjToRealTimeData(T obj) throws Exception {

        List<RealTimeDataVO> list = new ArrayList<>(); // 用于封装结果
        Class<? extends Object> classz = obj.getClass(); // 获取类型
        Field[] fields = classz.getDeclaredFields();// 获取实体类的所有属性，返回Field数组
        String nameId = null; // 先获取属性id（编号的值）
        String jkfmscssv = null;// 井口阀门开关状态SCSSV（是否激活，单独处理）
        String jkfmssv = null; // 井口阀门开关状态SSV（是否激活）
        String activate = null; // 判断是否激活
        Date sj = null;
        for (Field field : fields) {
            String name = field.getName();
            PropertyDescriptor propDesc = new PropertyDescriptor(name, classz);
            // 获取读取属性方法
            Method readGetId = propDesc.getReadMethod();
            if ("id".equalsIgnoreCase(name)) {
                nameId = (String) readGetId.invoke(obj);
            } else if ("jkfmscssv".equalsIgnoreCase(name)) {
                jkfmscssv = (String) readGetId.invoke(obj);
            } else if ("jkfmssv".equalsIgnoreCase(name)) {
                jkfmssv = (String) readGetId.invoke(obj);
            } else if ("sj".equalsIgnoreCase(name)) {
                sj = DateUtils.parseDate((String) readGetId.invoke(obj), "yyyy-MM-dd HH:mm:ss");
            }
        }
        if (jkfmscssv != null && jkfmssv != null) { // 若不为空说明是井的数据
            if ("1".equals(jkfmscssv) && "1".equals(jkfmssv)) {
                activate = "1";
            } else {
                activate = "0";
            }
            list.add(new RealTimeDataVO(nameId, 3, activate)); // 是否激活
        }

        // 遍历属性向，将数据封装到RealTimeDataVO中
        for (int j = 0; j < fields.length; j++) {
            // 获取属性名
            String name = fields[j].getName();
            // 获取bean的某个属性的描述符
            PropertyDescriptor propDesc = new PropertyDescriptor(name, classz);
            // 获取读取属性方法
            Method readGetId = propDesc.getReadMethod();
            // 获取属性值
            String value = (String) readGetId.invoke(obj);
            // 判读
            if (classz.equals(YardVO.class)) {  /* 管网运行-站场实时数据 */
                if (name.equalsIgnoreCase("CZGXQDF")) // 出站管线切断阀
                    list.add(new RealTimeDataVO(nameId, 39, value));
                else if (name.equalsIgnoreCase("CKLLXZZ")) {
                    // 站场出口流量-修正值
                    if (value != null) {
                        value = ((Double.parseDouble(value) * 10000) / ((sj.getTime() - new Date(0).getTime()) / 1000)) + "";
                    }
                    list.add(new RealTimeDataVO(nameId, 38, value)); // 需要修改单位，万方改为立方/s
                } else if (name.equalsIgnoreCase("JKWD")) // 站场进口温度
                    list.add(new RealTimeDataVO(nameId, 32, value));
                else if (name.equalsIgnoreCase("CKWD")) // 站场出口温度
                    list.add(new RealTimeDataVO(nameId, 33, value));
                else if (name.equalsIgnoreCase("CKYL")) // 站场出口压力
                    list.add(new RealTimeDataVO(nameId, 35, value));
                else if (name.equalsIgnoreCase("JKYL")) // 站场进口压力
                    list.add(new RealTimeDataVO(nameId, 34, value));
                else if (name.equalsIgnoreCase("CKYLSDZ")) // 站场出口压力-设定值
                    list.add(new RealTimeDataVO(nameId, 36, value));
                else if (name.equalsIgnoreCase("CKLL")) // 站场出口流量
                    list.add(new RealTimeDataVO(nameId, 37, value));
                else if (name.equalsIgnoreCase("CKLLSDZ")) { } // 暂预留//站场出口流量-设定值
            } else if (classz.equals(SingleWellVO.class)){ /* 井 */
                if (name.equalsIgnoreCase("JKYLSDZ")) // 井口压力-设定值
                    list.add(new RealTimeDataVO(nameId, 42, value));
                else if (name.equalsIgnoreCase("SSLL")) {// 瞬时流量,万方/d 改为 立方/s
                    if (value != null) {
                        value = ((Double.parseDouble(value) * 10000) / ((sj.getTime() - new Date(0).getTime()) / 1000)) + "";
                    }
                    list.add(new RealTimeDataVO(nameId, 40, value));
                } else if (name.equalsIgnoreCase("JKYL")) // 井口压力
                    list.add(new RealTimeDataVO(nameId, 41, value));
                else if (name.equalsIgnoreCase("JKWD")) // 井口温度号
                    list.add(new RealTimeDataVO(nameId, 43, value));
                else if (name.equalsIgnoreCase("JKLL")) {
                } // 井口流量(预留)
            }else if (classz.equals(HeatingFurnaceVO.class)){// 管网运行-加热炉实时数据
                if (name.equalsIgnoreCase("JKWD")) // 出口温度
                    list.add(new RealTimeDataVO(nameId, 44, value));
                else if (name.equalsIgnoreCase("JKWD")) // 进口温度
                    list.add(new RealTimeDataVO(nameId, 45, value));
                else if (name.equalsIgnoreCase("RKLL")) // 入口流量
                    list.add(new RealTimeDataVO(nameId, 48, value));
                else if (name.equalsIgnoreCase("DRLJ")) // 当日累计
                    list.add(new RealTimeDataVO(nameId, 49, value));
                else if (name.equalsIgnoreCase("CKYL")) // 出口压力
                    list.add(new RealTimeDataVO(nameId, 46, value));
                else if (name.equalsIgnoreCase("JKYL")) // 进口压力
                    list.add(new RealTimeDataVO(nameId, 47, value));
                else if (name.equalsIgnoreCase("DRLJXZ")) // 当日累计-修正
                    list.add(new RealTimeDataVO(nameId, 50, value));
            }
        }
        return list;
    }

    /**
     *
     * @param obj 实时数据对象
     * @param simulationMap 用于组织数据
     * @param <T> 泛型为传入的实时数据对象类型
     * @return
     * @throws Exception
     */
    public static <T> List<RealTiemSimulationVO> reflectObjToSimulation(T obj, Map<String, List<RealTiemSimulationVO>> simulationMap) throws Exception {
        List<RealTiemSimulationVO> list = new ArrayList<>();
        Class<? extends Object> classz = obj.getClass(); // 获取类型
        Field[] fields = classz.getDeclaredFields();// 获取实体类的所有属性，返回Field数组
        String elimentName = null; // 实时数据中的设备名
        Date sj = null; // 实时数据中的转储时间
        // 获取实数数据中的设备名
        for (Field field : fields) {
            // 获取属性名
            String name = field.getName();
            // 获取bean的某个属性的描述符
            PropertyDescriptor propDesc = new PropertyDescriptor(name, classz);
            // 获取读取属性方法
            Method readMethod = propDesc.getReadMethod();
            if ("zcmc".equalsIgnoreCase(name)) {
                // 获取属性值
                elimentName = (String) readMethod.invoke(obj);
            } else if ("jh".equalsIgnoreCase(name)) {
                elimentName = (String) readMethod.invoke(obj);
            } else if ("jrl".equalsIgnoreCase(name)) {
                elimentName = (String) readMethod.invoke(obj);
            } else if ("sj".equalsIgnoreCase(name)) {
                sj = DateUtils.parseDate((String) readMethod.invoke(obj), "yyyy-MM-dd HH:mm:ss");
            }
        }

        // 编号唯一,list中只有一条数据
        List<RealTiemSimulationVO> realTiemSimulationVOS = simulationMap.get(elimentName);
        // 判断是否为空
        if (realTiemSimulationVOS != null){
            //        String elementname = realTiemSimulationVOS.get(0).getElementname(); // 设备名称
            String elementid = realTiemSimulationVOS.get(0).getElementid(); // 设备编码
            String pipeName = realTiemSimulationVOS.get(0).getPipesimName(); //仿真模拟真实名称

            // 遍历实时数据对象属性
            for (int j = 0; j < fields.length; j++) {
                // 获取属性名
                String name = fields[j].getName();
                // 获取bean的某个属性的描述符
                PropertyDescriptor propDesc = new PropertyDescriptor(name, classz);
                // 获取读取属性方法
                Method readMethod = propDesc.getReadMethod();
                // 获取属性值
                String value = (String) readMethod.invoke(obj);

                // 判断获取的实时数据是否有异常数据，如某时刻数据为null
                if (value != null) {
                    /* 管网运行-站场实时数据 */
                    if (YardVO.class.equals(classz)) {
                        if (name.equalsIgnoreCase("CKWD")) //站场出口温度33
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.TEMPERATURE", Double.parseDouble(value)));
                        else if (name.equalsIgnoreCase("CKYL")) //站场出口压力35
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.PRESSURE", Double.parseDouble(value)));
                        else if (name.equalsIgnoreCase("CKLL")) { //站场出口流量37, 该值需单位为万立方，需算为立方每秒
                            //double result = (Double.parseDouble(value)*10000)/((sj.getTime()-new Date(0).getTime())/1000);
                            Random r = new Random();
                            Double result = r.nextDouble() * 3 + 8;
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.GASFLOWRATE ", result));
                        }
                    } else if (SingleWellVO.class.equals(classz)) {
                        /* 管网运行-井实时数据 */
                        if (name.equalsIgnoreCase("SSLL")) //瞬时流量40
                            // 单位为km3/d 转化为m3/s
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.GASFLOWRATE ", (Double.parseDouble(value) * 10000) / ((sj.getTime() - new Date(0).getTime()) / 1000)));
                        else if (name.equalsIgnoreCase("JKYL")) //井口压力41
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.PRESSURE", Double.parseDouble(value)));
                        else if (name.equalsIgnoreCase("JKWD")) //井口温度43
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.TEMPERATURE", Double.parseDouble(value)));
                    }
                } else {
                    if (YardVO.class.equals(classz)) {
                        /* 管网运行-站场实时数据 */
                        if (name.equalsIgnoreCase("CKWD")) //站场出口温度33
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.TEMPERATURE", null));
                        else if (name.equalsIgnoreCase("CKYL")) //站场出口压力35
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.PRESSURE", null));
                        else if (name.equalsIgnoreCase("CKLL")) //站场出口流量37, 该值需单位为立方，需算为
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.GASFLOWRATE ", null));

                    } else if (SingleWellVO.class.equals(classz)) {
                        /* 管网运行-井实时数据 */
                        if (name.equalsIgnoreCase("SSLL")) //瞬时流量40
                            // 单位为km3/d 转化为m3/s
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.GASFLOWRATE ", null));
                        else if (name.equalsIgnoreCase("JKYL")) //井口压力41
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.PRESSURE", null));
                        else if (name.equalsIgnoreCase("JKWD")) //井口温度43
                            list.add(new RealTiemSimulationVO(pipeName, elementid, null, "Parameters.Source.TEMPERATURE", null));
                    }

                }
            }
        }

        return list;
    }
}
