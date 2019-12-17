/** 
 * @file: ElementVo.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月26日 上午10:56:12 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;

import java.io.Serializable;

/**
 * @ClassName ElementVo
 * @Description TODO(站场内设备) 
 * @Author 周伟
 * @Date 2019年11月26日 上午10:56:12
 */
public class ElementVO implements Serializable{
    
    private String elementname;//设备名
    private String elementid;//设备id
    private String elementtype;//设备类型
    
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

    @Override
    public String toString() {
        return "ElementVo [elementname=" + elementname + ", elementid=" + elementid + ", elementtype=" + elementtype
                + "]";
    }
    
    

}
