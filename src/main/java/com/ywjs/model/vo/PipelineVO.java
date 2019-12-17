/** 
 * @file: PipelineVO.java 
 * @Package： com.ywjs.model.vo 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月26日 上午11:01:48 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.vo;

import java.io.Serializable;

/**
 * @ClassName PipelineVO
 * @Description TODO(管线) 
 * @Author 周伟
 * @Date 2019年11月26日 上午11:01:48
 */
public class PipelineVO implements Serializable{
    
    private String pipelinename;//管线名称
    private String pipelineid;//管线编号
    
    public String getPipelinename() {
        return pipelinename;
    }
    
    public void setPipelinename(String pipelinename) {
        this.pipelinename = pipelinename;
    }
    
    public String getPipelineid() {
        return pipelineid;
    }
    
    public void setPipelineid(String pipelineid) {
        this.pipelineid = pipelineid;
    }

    @Override
    public String toString() {
        return "PipelineVO [pipelinename=" + pipelinename + ", pipelineid=" + pipelineid + "]";
    }

    
}
