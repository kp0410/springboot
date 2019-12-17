/** 
 * @file: PpenProject.java 
 * @Package： com.ywjs.model.dto 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月18日 下午5:40:48 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.dto;


/**
 * @ClassName OpenProjectDTO
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年11月18日 下午5:40:48
 */
public class IdtypeDTO {
    
    private Long projectid;
    private Integer idtype;
    
    public Long getProjectid() {
        return projectid;
    }
    
    public void setProjectid(Long projectid) {
        this.projectid = projectid;
    }
    
    public Integer getIdtype() {
        return idtype;
    }
    
    public void setIdtype(Integer idtype) {
        this.idtype = idtype;
    }

    @Override
    public String toString() {
        return "PpenProject [projectid=" + projectid + ", idtype=" + idtype + "]";
    }
    
    

}
