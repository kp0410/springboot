package com.ywjs.pythontookit.pipesimutil;


/**
 * PIPESIM相关单位转换
 */
public class PipesimConversionUnit {

    /**
     * 摄氏度转华氏度 -- 温度
     * @param defc 摄氏度
     * @return
     */
    public static Double wddegcTodegf(Double defc){
        Double degf = (defc * 9 / 5) + 32;
        return degf;
    }

    /**
     * 华氏度转摄氏度 -- 温度
     * @param degf 华氏度
     * @return
     */
    public static Double wddegfTodegc(Double degf){
        Double degc = 5 * (degf - 32) / 9;
        return degc;
    }

    /**
     * 华氏度转开氏度 -- 温度 K＝5/9（°F+459.67)
     * @param degf 华氏度
     * @return
     */
    public static Double wdDegfToDegk(Double degf){
        Double degk = 5  * (degf + 459.67) / 9 ;
        return degk;
    }

    /**
     * 开氏度转华氏度 -- 温度
     * @param degk 开氏度
     * @return
     */
    public static Double wdDegkToDegf(Double degk){
        Double degf = degk * 9 / 5 - 459.67;
        return degf;
    }

    /**
     * 摄氏度转开氏度
     * @param degc
     * @return
     */
    public static Double wdDegcToDegk(Double degc){
        Double degk = degc + 273.15;
        return degk;
    }

    /**
     * 开氏度转摄氏度
     * @param degk
     * @return
     */
    public static Double wdDegkToDegc(Double degk){
        Double degc = degk - 273.15;
        return degc;
    }


    /**
     * 磅力/平方英寸 转 兆帕  -- 压力
     * @param pisa
     * @return
     */
    public static Double ylpisaTompa(Double pisa){
        Double mpa =  pisa * 0.0068948;//单位转换psia 转为Mpa
        return mpa;
    }

    /**
     * 兆帕 转 磅力/平方英寸 -- 压力
     * @param mpa
     * @return
     */
    public static Double ylmpaTopsia(Double mpa){
        Double psia =  mpa / 0.0068948;
        return psia;
    }

    /**
     * 百万标准立方英尺每天 转 立方米每秒
     * mmscf/d 转 m³/s  -- 流速
     * @param mscfd
     * @return
     */
    public static Double lsmscfdToms(Double mscfd){
        Double ms =  mscfd * Math.pow(0.3048,3) * 1e6 / 24 / 60 / 60;
        return ms;
    }

    /**
     * 立方米每秒 转 百万标准立方英尺每天
     * m³/s 转 mmscf/d -- 流速
     * @param ms
     * @return
     */
    public static Double lsmsTomscfd(Double ms){
        Double mscfd = ms * 60 * 60 * 24 / Math.pow(0.3048,3) / 1e6;
        return mscfd;
    }

    /**
     * m(米)转in(英寸) -- 流线内径
     * @param m
     * @return
     */
    public static Double mToIn(Double m){
        Double in = m * 39.3700787;
        return in;
    }

    /**
     * in(英寸)转m(米) -- 流线内径
     * @param in
     * @return
     */
    public static Double inToM(Double in){
        Double m = in / 39.3700787;
        return m;
    }

    /**
     * in(英尺)转m(米) -- 里程
     * @param ft
     * @return
     */
    public static Double ftToM(Double ft){
        Double m = ft * 0.3048;
        return m;
    }

    /**
     * m(米)转in(英尺) -- 里程
     * @param m
     * @return
     */
    public static Double mToFt(Double m){
        Double ft = m / 0.3048;
        return ft;
    }



    /**
     * 密度单位转换  磅每立方英尺 转 千克每立方米
     * lbm/ft3转kg/m³
     */
    public static Double miduLbftToKgm(Double lbft){
        double kgm3 = lbft * 0.4535924 / Math.pow(0.3048, 3);
        return kgm3;
    }

    /**
     * 密度单位转换  千克每立方米 转 磅每立方英尺
     * kg/m³转lbm/ft3
     */
    public static Double miduKgmToLbft(Double kgm){
        double lbft = kgm / 0.4535924 * Math.pow(0.3048, 3);
        return lbft;
    }

    /**
     * 比热单位转换 英热每磅华氏度 转 焦耳每千克开氏度
     * Btu/(lbm.degF) 转 J/(kg.K)
     */
    public static Double bireBtuToJ(Double btu){
        Double j = btu * 4186.8 ;
        return j;
    }

    /**
     * 比热单位转换 焦耳/公斤 转 英热单位/磅
     * J/(kg.K) 转 Btu/(lbm.degF)
     */
    public static Double bireJToBtn(Double j){
        Double btn = j / 4186.8;
        return btn;
    }



}
