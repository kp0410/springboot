package com.ywjs.model.entity;

import java.io.Serializable;

/**
 * 
 * @ClassName PropertyValue
 * @Description TODO(属性值实体) 
 * @Author 周伟
 * @Date 2019年11月26日 下午4:23:15
 */
public class PropertyValue implements Serializable {
    private Long provalueidProval; //属性值id

    private Long workidWork; //工况id

    private Integer propertyidPro; //属性id

    private String elementrealnameEle; //元件编号

    private String provalueProval; //属性值,数组用逗号隔开

    private static final long serialVersionUID = 1L;

    public Long getProvalueidProval() {
        return provalueidProval;
    }

    public void setProvalueidProval(Long provalueidProval) {
        this.provalueidProval = provalueidProval;
    }

    public Long getWorkidWork() {
        return workidWork;
    }

    public void setWorkidWork(Long workidWork) {
        this.workidWork = workidWork;
    }

    public Integer getPropertyidPro() {
        return propertyidPro;
    }

    public void setPropertyidPro(Integer propertyidPro) {
        this.propertyidPro = propertyidPro;
    }

    public String getElementrealnameEle() {
        return elementrealnameEle;
    }

    public void setElementrealnameEle(String elementrealnameEle) {
        this.elementrealnameEle = elementrealnameEle == null ? null : elementrealnameEle.trim();
    }

    public String getProvalueProval() {
        return provalueProval;
    }

    public void setProvalueProval(String provalueProval) {
        this.provalueProval = provalueProval == null ? null : provalueProval.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", provalueidProval=").append(provalueidProval);
        sb.append(", workidWork=").append(workidWork);
        sb.append(", propertyidPro=").append(propertyidPro);
        sb.append(", elementrealnameEle=").append(elementrealnameEle);
        sb.append(", provalueProval=").append(provalueProval);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}