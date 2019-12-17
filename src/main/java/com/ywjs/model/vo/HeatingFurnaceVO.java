/** 
 * @file: HeatingFurnace.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月28日 下午4:00:33 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;


/**
 * @ClassName HeatingFurnace
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年11月28日 下午4:00:33
 */
public class HeatingFurnaceVO {

    private String id; //站场编号（保留字段）
    private String zcmc;//    站场名称
    private String jh;//  井号
    private String jrl;// 加热炉名称
    private String ckwd;//    出口温度
    private String jkwd;//    进口温度
    private String rkll;//    入口流量
    private String drlj;//    当日累计
    private String ckyl;//    出口压力
    private String jkyl;//    进口压力
    private String drljxz;//  当日累计-修正
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
    
    public String getJrl() {
        return jrl;
    }
    
    public void setJrl(String jrl) {
        this.jrl = jrl;
    }
    
    public String getCkwd() {
        return ckwd;
    }
    
    public void setCkwd(String ckwd) {
        this.ckwd = ckwd;
    }
    
    public String getJkwd() {
        return jkwd;
    }
    
    public void setJkwd(String jkwd) {
        this.jkwd = jkwd;
    }
    
    public String getRkll() {
        return rkll;
    }
    
    public void setRkll(String rkll) {
        this.rkll = rkll;
    }
    
    public String getDrlj() {
        return drlj;
    }
    
    public void setDrlj(String drlj) {
        this.drlj = drlj;
    }
    
    public String getCkyl() {
        return ckyl;
    }
    
    public void setCkyl(String ckyl) {
        this.ckyl = ckyl;
    }
    
    public String getJkyl() {
        return jkyl;
    }
    
    public void setJkyl(String jkyl) {
        this.jkyl = jkyl;
    }
    
    public String getDrljxz() {
        return drljxz;
    }
    
    public void setDrljxz(String drljxz) {
        this.drljxz = drljxz;
    }
    
    public String getSj() {
        return sj;
    }
    
    public void setSj(String sj) {
        this.sj = sj;
    }

    @Override
    public String toString() {
        return "HeatingFurnace [zcmc=" + zcmc + ", jh=" + jh + ", jrl=" + jrl + ", ckwd=" + ckwd + ", jkwd=" + jkwd
                + ", rkll=" + rkll + ", drlj=" + drlj + ", ckyl=" + ckyl + ", jkyl=" + jkyl + ", drljxz=" + drljxz
                + ", sj=" + sj + "]";
    }
    
    
    
}
