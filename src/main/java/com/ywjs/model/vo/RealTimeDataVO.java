/** 
 * @file: RealTimeDataVO.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月28日 下午7:01:32 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;


/**
 * @ClassName RealTimeDataVO
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年11月28日 下午7:01:32
 */
public class RealTimeDataVO {
    
    //元件编号，包括站场、设备、管线
    private String  elementid;
    //属性编号 来自属性表
    private Integer  propertyid;
    //属性值，来自静态数据(查询的数据)
    private String  propertyvalue;
    
    public String getElementid() {
        return elementid;
    }
    
    public RealTimeDataVO(String elementid, Integer propertyid, String propertyvalue) {
        super();
        this.elementid = elementid;
        this.propertyid = propertyid;
        this.propertyvalue = propertyvalue;
    }



    public void setElementid(String elementid) {
        this.elementid = elementid;
    }
    
    public Integer getPropertyid() {
        return propertyid;
    }
    
    public void setPropertyid(Integer propertyid) {
        this.propertyid = propertyid;
    }
    
    public String getPropertyvalue() {
        return propertyvalue;
    }
    
    public void setPropertyvalue(String propertyvalue) {
        this.propertyvalue = propertyvalue;
    }
    
    

}
