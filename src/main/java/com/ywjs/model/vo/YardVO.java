/** 
 * @file: YardVO.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月28日 上午10:49:01 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName YardVO
 * @Description TODO(站场接收数据VO) 
 * @Author 周伟
 * @Date 2019年11月28日 上午10:49:01
 */
public class YardVO  implements Serializable{

    private String id; //编号（保留字段）
    private String zcmc;//    站场名称
    private String czgxqdf;// 出站管线切断阀
    private String ckllxzz;// 站场出口流量-修正值
    private String jkwd;//    站场进口温度
    private String ckwd;//    站场出口温度
    private String ckyl;//    站场出口压力
    private String jkyl;//    站场进口压力
    private String ckylsdz;// 站场出口压力-设定值
    private String ckll;//    站场出口流量
    private String ckllsdz;// 站场出口流量-设定值
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
    
    public String getCzgxqdf() {
        return czgxqdf;
    }
    
    public void setCzgxqdf(String czgxqdf) {
        this.czgxqdf = czgxqdf;
    }
    
    public String getCkllxzz() {
        return ckllxzz;
    }
    
    public void setCkllxzz(String ckllxzz) {
        this.ckllxzz = ckllxzz;
    }
    
    public String getJkwd() {
        return jkwd;
    }
    
    public void setJkwd(String jkwd) {
        this.jkwd = jkwd;
    }
    
    public String getCkwd() {
        return ckwd;
    }
    
    public void setCkwd(String ckwd) {
        this.ckwd = ckwd;
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
    
    public String getCkylsdz() {
        return ckylsdz;
    }
    
    public void setCkylsdz(String ckylsdz) {
        this.ckylsdz = ckylsdz;
    }
    
    public String getCkll() {
        return ckll;
    }
    
    public void setCkll(String ckll) {
        this.ckll = ckll;
    }
    
    public String getCkllsdz() {
        return ckllsdz;
    }
    
    public void setCkllsdz(String ckllsdz) {
        this.ckllsdz = ckllsdz;
    }
    
    public String getSj() {
        return sj;
    }
    
    public void setSj(String sj) {
        this.sj = sj;
    }

    @Override
    public String toString() {
        return "YardVO [id=" + id + ", zcmc=" + zcmc + ", czgxqdf=" + czgxqdf + ", ckllxzz=" + ckllxzz + ", jkwd="
                + jkwd + ", ckwd=" + ckwd + ", ckyl=" + ckyl + ", jkyl=" + jkyl + ", ckylsdz=" + ckylsdz + ", ckll="
                + ckll + ", ckllsdz=" + ckllsdz + ", sj=" + sj + "]";
    }
    
    
    
}
