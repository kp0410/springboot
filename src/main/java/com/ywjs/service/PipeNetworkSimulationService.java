/** 
 * @file: PipeNetworkSimulationService.java 
 * @Package： com.ywjs.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月26日 上午11:28:15 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.service;

import com.ywjs.model.dto.IdtypeDTO;
import com.ywjs.model.dto.SetRealTiemFzmnDTO;

/**
 * 
 * @ClassName PipeNetworkSimulationService
 * @Description TODO(管网仿真模拟接口) 
 * @Author 周伟
 * @Date 2019年11月26日 上午11:29:15
 */
public interface PipeNetworkSimulationService {

    /**
     * @Description: TODO(获取仿真模拟方案列表) 
     * @author： 2019年11月26日  周伟  创建初始版本
     * @param idtypeDTO
     * @return
     */
    Object getSimulationList(IdtypeDTO idtypeDTO);

    /**
     * @Description: TODO(实时仿真模拟计算) 
     * @author： 2019年12月3日  周伟  创建初始版本
     * @param setRealTiemFzmnDTO
     */
    void setrealtiemfzmn(SetRealTiemFzmnDTO setRealTiemFzmnDTO);

}
