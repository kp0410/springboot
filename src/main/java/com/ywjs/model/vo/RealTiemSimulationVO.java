/** 
 * @file: RealTiemSimulationVO.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年12月3日 下午1:55:12 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;

import java.io.Serializable;

/**
 * @ClassName RealTiemSimulationVO
 * @Description 实时仿真模拟计算 VO
 * @Author 周伟
 * @Date 2019年12月3日 下午1:55:12
 */
public class RealTiemSimulationVO implements Serializable{

    //仿真模拟真实名称
    private  String pipesimName;
    
  //名称（设备名称）
    private String  elementname ;
   //需要入库 设备编码
    private String  elementid ;
   //1管线，2其他
    private String elementtype ;
    //属性代码（）
    private String  propertykey ;
    //属性值
    private Double  propertyvalue ;

    public String getPipesimName() {
        return pipesimName;
    }

    public void setPipesimName(String pipesimName) {
        this.pipesimName = pipesimName;
    }

    public RealTiemSimulationVO(String elementname, String elementid, String elementtype, String propertykey,
                                Double propertyvalue) {
        this.elementname = elementname;
        this.elementid = elementid;
        this.elementtype = elementtype;
        this.propertykey = propertykey;
        this.propertyvalue = propertyvalue;
    }

    public RealTiemSimulationVO(String elementname, String elementid,String pipesimName) {
        this.elementname = elementname;
        this.elementid = elementid;
        this.pipesimName = pipesimName;
    }

    public String getElementname() {
        return elementname;
    }
    
    public void setElementname(String elementname) {
        this.elementname = elementname;
    }
    
    public String getElementid() {
        return elementid;
    }
    
    public void setElementid(String elementid) {
        this.elementid = elementid;
    }
    
    public String getElementtype() {
        return elementtype;
    }
    
    public void setElementtype(String elementtype) {
        this.elementtype = elementtype;
    }
    
    public String getPropertykey() {
        return propertykey;
    }
    
    public void setPropertykey(String propertykey) {
        this.propertykey = propertykey;
    }
    
    public Double getPropertyvalue() {
        return propertyvalue;
    }
    
    public void setPropertyvalue(Double propertyvalue) {
        this.propertyvalue = propertyvalue;
    }

}
