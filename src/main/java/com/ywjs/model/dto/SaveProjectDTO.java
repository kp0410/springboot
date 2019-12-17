/** 
 * @file: SaveProjectDTO.java 
 * @Package： com.ywjs.model.dto 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月13日 下午5:29:22 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.dto;

import java.util.List;

import com.ywjs.model.entity.Element;
import com.ywjs.model.entity.ElementNode;
import com.ywjs.model.entity.PropertyValue;
import com.ywjs.model.entity.WorkingCondition;

/**
 * @ClassName SaveProjectDTO
 * @Description TODO(工程模型数据传输对象) 
 * @Author 周伟
 * @Date 2019年11月13日 下午5:29:22
 */
public class SaveProjectDTO {
    
    private Long projectid;
    private Integer issaveproaff;
    private String remark;
    private Long projectaffid;
    private List<WorkingCondition> arclist;
    private List<PropertyValue> attrilist;
    private List<Element> elementlist;
    private List<ElementNode> nodelist;
    
    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    
    public Long getProjectaffid() {
        return projectaffid;
    }

    
    public void setProjectaffid(Long projectaffid) {
        this.projectaffid = projectaffid;
    }
    
    public Long getProjectid() {
        return projectid;
    }
    
    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }
    
    public Integer getIssaveproaff() {
        return issaveproaff;
    }
    
    public void setIssaveproaff(Integer issaveproaff) {
        this.issaveproaff = issaveproaff;
    }
    
    public List<WorkingCondition> getArclist() {
        return arclist;
    }
    
    public void setArclist(List<WorkingCondition> arclist) {
        this.arclist = arclist;
    }
    
    public List<PropertyValue> getAttrilist() {
        return attrilist;
    }
    
    public void setAttrilist(List<PropertyValue> attrilist) {
        this.attrilist = attrilist;
    }
    
    public List<Element> getElementlist() {
        return elementlist;
    }
    
    public void setElementlist(List<Element> elementlist) {
        this.elementlist = elementlist;
    }
    
    public List<ElementNode> getNodelist() {
        return nodelist;
    }
    
    public void setNodelist(List<ElementNode> nodelist) {
        this.nodelist = nodelist;
    }


    @Override
    public String toString() {
        return "SaveProjectDTO [projectid=" + projectid + ", issaveproaff=" + issaveproaff + ", remark=" + remark
                + ", projectaffid=" + projectaffid + ", arclist=" + arclist + ", attrilist=" + attrilist
                + ", elementlist=" + elementlist + ", nodelist=" + nodelist + "]";
    }

}
