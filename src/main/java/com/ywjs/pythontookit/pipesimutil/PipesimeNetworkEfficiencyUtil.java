package com.ywjs.pythontookit.pipesimutil;

/**
 * 管网效率计算
 */
public class PipesimeNetworkEfficiencyUtil {

    /**
     * 管路效率     出口/进口
     * 出口
     * @param elevation 绝对高程 单位：m
     * @param pressure  压力 单位：MPa 转Pa
     * @param density   流体密度 单位：kg/m³
     * @param heat      比热 单位：J/(kg.℃) 转kJ/(kg.℃)
     * @param temperature   温度 单位：摄氏度转开氏度
     * @return
     */
    public static Double lineOut(Double elevation,Double pressure,Double density,Double heat,Double temperature){
        Double out = 9.80665 * elevation + (pressure * 1e6 / density) + heat / 1e3 * PipesimConversionUnit.wdDegcToDegk(temperature);
        return out;
    }

    /**
     * 管路效率     出口/进口
     * 进口
     * @param elevation 绝对高程 单位：m
     * @param pressure  压力 单位：MPa 转Pa
     * @param density   流体密度 单位：kg/m³
     * @param heat      比热 单位：J/(kg.℃) 转kJ/(kg.℃)
     * @param temperature   温度 单位：摄氏度转开氏度
     * @return
     */
    public static Double lineIn(Double elevation,Double pressure,Double density,Double heat,Double temperature){
        Double in = 9.80665 * elevation + (pressure * 1e6 / density) + heat / 1e3 * PipesimConversionUnit.wdDegcToDegk(temperature);
        return in;
    }

    /**
     * 加热炉效率    流体获得的有效能量/加热炉消耗总能量
     * 加热炉消耗总能量
     * @param gasHeatValue  天然气的热值 单位：kJ/m³
     * @param gasConsumption    耗气量 单位：m³/s
     * @return
     */
    //TODO 需要获取相应的值
    public static Double totalEnergy(Double gasHeatValue,Double gasConsumption){
        Double totalEnergy = gasHeatValue * gasConsumption;
        return totalEnergy;
    }

    /**
     * 加热炉效率    流体获得的有效能量/加热炉消耗总能量
     * 流体获得的有效能量
     * @param outDensity        出口流体密度  单位：kg/m³
     * @param outConsumption    出口耗气量   单位：m³/s
     * @param outHeat           出口比热  单位：J/(kg.℃) 转kJ/(kg.℃)
     * @param outTemperature    出口温度  单位：摄氏度转开氏度
     * @param inHeat            进口比热  单位：J/(kg.℃) 转kJ/(kg.℃)
     * @param inTemperature     进口温度  单位：摄氏度转开氏度
     * @return
     */
    //TODO outConsumption是耗气量
    public static Double effectiveEnergy(Double outDensity,Double outConsumption,Double outHeat,Double outTemperature,Double inHeat,Double inTemperature){
        Double energy = outDensity * outConsumption * ((outHeat / 1e3) * PipesimConversionUnit.wdDegcToDegk(outTemperature) - (inHeat / 1e3) * PipesimConversionUnit.wdDegcToDegk(inTemperature));
        return energy;
    }

    /**
     * 集气站效率    有效能量之和/(总加热炉能量+总井能量)
     *  有效能量之和
     * @param outDensity 出口流体密度    kg/m³
     * @param outConsumption 出口耗气量  m³/s
     * @param outPressure   出口压力    MPa 转Pa
     * @param outHeat   出口比热    J/(kg.℃) 转kJ/(kg.℃)
     * @param outTemperature    出口温度    摄氏度转开氏度
     * @return
     */
    public static Double totalEffectiveEnergy(Double outDensity,Double outConsumption,Double outPressure,Double outHeat,Double outTemperature){
        Double total = outDensity * outConsumption * ((outPressure * 1e6) / outDensity   + (outHeat / 1e3) * PipesimConversionUnit.wdDegcToDegk(outTemperature));
        return total;
    }

    /**
     * 集气站效率
     *  加热炉能量
     * @param gasHeatValue  天然气热值 kJ/m³
     * @param gasConsumption    耗气量 m³/s
     * @return
     */
    public static Double heaterEnergy(Double gasHeatValue,Double gasConsumption){
        Double energy = gasConsumption * gasHeatValue;
        return energy;
    }

    /**
     * 集气站效率
     *  井能量
     * @param density   流体密度    kg/m³
     * @param consumption   耗气量 m³/s
     * @param pressure  压力  MPa 转Pa
     * @param heat  比热  J/(kg.℃) 转kJ/(kg.℃)
     * @param temperature   温度  摄氏度转开氏度
     * @return
     */
    public static Double wellEnergy(Double density,Double consumption,Double pressure,Double heat,Double temperature){
        Double energy = density * consumption * ((pressure * 1e6) / density + (heat / 1e3) * PipesimConversionUnit.wdDegcToDegk(temperature));
        return null;
    }

    /**
     * 管网效率 总集气站/总气井
     *  集气站
     * @param density 出口流体密度   kg/m³
     * @param consumption 出口耗气量 m³/s
     * @param elevation 出口高程    m
     * @param pressure  出口压力    MPa 转Pa
     * @param heat  出口比热    J/(kg.℃) 转kJ/(kg.℃)
     * @param temperature   出口温度    摄氏度转开氏度
     * @return
     */
    public static Double gasStation(Double density,Double consumption,Double elevation,Double pressure,Double heat,Double temperature){
        Double gas = density * consumption * (9.80665 * elevation + (pressure * 1e6 / density) + (heat / 1e3) * PipesimConversionUnit.wdDegcToDegk(temperature));
        return gas;
    }

    /**
     * 管网效率 总集气站/总气井
     *  气井
     * @param density 进口流体密度    kg/m³
     * @param consumption 进口耗气量     m³/s
     * @param elevation 进口高程    m
     * @param pressure 进口压力     MPa 转Pa
     * @param heat  进口比热    J/(kg.℃) 转kJ/(kg.℃)
     * @param temperature   进口温度    摄氏度转开氏度
     * @return
     */
    public static Double gasWell(Double density,Double consumption,Double elevation,Double pressure,Double heat,Double temperature){
        Double well = density * consumption * (9.80665 * elevation + (pressure * 1e6 / density) + (heat / 1e3) * PipesimConversionUnit.wdDegcToDegk(temperature));
        return well;
    }

    /**
     * 集输系统效率 集气总站/(总气井+总加热炉)
     *  集气总站
     * @param density 出口密度  kg/m³
     * @param consumption   出口耗气量   m³/s
     * @param elevation     出口高程    m
     * @param pressure      出口压力    MPa 转Pa
     * @param heat      出口比热    J/(kg.℃) 转kJ/(kg.℃)
     * @param temperature   出口温度    摄氏度转开氏度
     * @return
     */
    public static Double totalGasStation(Double density,Double consumption,Double elevation,Double pressure,Double heat,Double temperature){
        Double jishu = density * consumption * (9.80665 * elevation + (pressure * 1e6 / density) + (heat / 1e3) * PipesimConversionUnit.wdDegcToDegk(temperature));
        return jishu;
    }



}
