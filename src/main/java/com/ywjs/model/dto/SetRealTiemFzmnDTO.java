/** 
 * @file: setRealTiemFzmnDTO.java 
 * @Package： com.ywjs.model.dto 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年12月3日 上午10:56:13 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.model.dto;

import java.util.List;

import com.ywjs.model.entity.RealtimeSimulation;

/**
 * @ClassName setRealTiemFzmnDTO
 * @Description TODO(5.1.13实时仿真模拟计算数据传输类) 
 * @Author 周伟
 * @Date 2019年12月3日 上午10:56:13
 */
public class SetRealTiemFzmnDTO {
    
    private RealtimeSimulation realsimlist;
    private List<?> simsettinglist; //元素为map类型{"key":"a" , "value":"1"}

    
    
    public RealtimeSimulation getRealsimlist() {
        return realsimlist;
    }


    
    public void setRealsimlist(RealtimeSimulation realsimlist) {
        this.realsimlist = realsimlist;
    }


    public List<?> getSimsettinglist() {
        return simsettinglist;
    }

    
    public void setSimsettinglist(List<?> simsettinglist) {
        this.simsettinglist = simsettinglist;
    }
    
    

}
