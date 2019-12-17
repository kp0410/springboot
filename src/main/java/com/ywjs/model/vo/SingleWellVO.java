/** 
 * @file: SingleWell.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月28日 下午3:36:33 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;

import java.io.Serializable;

/**
 * @ClassName SingleWell
 * @Description TODO(单井实时数据实体) 
 * @Author 周伟
 * @Date 2019年11月28日 下午3:36:33
 */
public class SingleWellVO implements Serializable{
    
    private String id; //站场编号（保留字段）
    private String zcmc;//    站场名称
    private String jh;//  井号
    private String jkfmscssv;//   井口阀门开关状态SCSSV
    private String jkylsdz;// 井口压力-设定值
    private String ssll;//    瞬时流量
    private String jkfmssv;// 井口阀门开关状态SSV
    private String jkyl;//    井口压力
    private String jkwd;//    井口温度
    private String jkll;//    井口流量
    private String sj;//  转储时间
    
    
    public String getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public String getZcmc() {
        return zcmc;
    }
    
    public void setZcmc(String zcmc) {
        this.zcmc = zcmc;
    }
    
    public String getJh() {
        return jh;
    }
    
    public void setJh(String jh) {
        this.jh = jh;
    }
    
    public String getJkfmscssv() {
        return jkfmscssv;
    }
    
    public void setJkfmscssv(String jkfmscssv) {
        this.jkfmscssv = jkfmscssv;
    }
    
    public String getJkylsdz() {
        return jkylsdz;
    }
    
    public void setJkylsdz(String jkylsdz) {
        this.jkylsdz = jkylsdz;
    }
    
    public String getSsll() {
        return ssll;
    }
    
    public void setSsll(String ssll) {
        this.ssll = ssll;
    }
    
    public String getJkfmssv() {
        return jkfmssv;
    }
    
    public void setJkfmssv(String jkfmssv) {
        this.jkfmssv = jkfmssv;
    }
    
    public String getJkyl() {
        return jkyl;
    }
    
    public void setJkyl(String jkyl) {
        this.jkyl = jkyl;
    }
    
    public String getJkwd() {
        return jkwd;
    }
    
    public void setJkwd(String jkwd) {
        this.jkwd = jkwd;
    }
    
    public String getJkll() {
        return jkll;
    }
    
    public void setJkll(String jkll) {
        this.jkll = jkll;
    }
    
    public String getSj() {
        return sj;
    }
    
    public void setSj(String sj) {
        this.sj = sj;
    }

    @Override
    public String toString() {
        return "SingleWellVO [zcmc=" + zcmc + ", jh=" + jh + ", jkfmscssv=" + jkfmscssv + ", jkylsdz=" + jkylsdz
                + ", ssll=" + ssll + ", jkfmssv=" + jkfmssv + ", jkyl=" + jkyl + ", jkwd=" + jkwd + ", jkll=" + jkll
                + ", sj=" + sj + "]";
    }
    
    

}
