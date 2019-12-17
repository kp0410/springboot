/** 
 * @file: PipeNetworkRunOptimizePlanService.java 
 * @Package： com.ywjs.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月25日 下午5:10:01 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.service;

import java.util.List;

import com.ywjs.model.entity.Operation;
import com.ywjs.model.entity.Optimize;

/**
 * @ClassName PipeNetworkRunOptimizePlanService
 * @Description TODO(管网运行优化方案Service) 
 * @Author 周伟
 * @Date 2019年11月25日 下午5:10:01
 */
public interface PipeNetworkRunOptimizePlanService {

    /**
     * @Description: TODO(获取运行优化方案管理信息) 
     * @author： 2019年11月25日  周伟  创建初始版本
     * @return
     */
    List<Operation> getRunOptimizeInfo();

    /**
     * @Description: TODO(批量删除运行方案优选方案管理) 
     * @author： 2019年11月25日  周伟  创建初始版本
     * @param ids
     */
    void deleteBatchRunOptimize(Long[] ids);

    /**
     * @Description: TODO(获取运行方案优化管理信息) 
     * @author： 2019年11月26日  周伟  创建初始版本
     * @return
     */
    List<Optimize> getRunOptimalInfo();

    /**
     * @Description: TODO(删除运行方案优化管理信息) 
     * @author： 2019年11月26日  周伟  创建初始版本
     * @param id
     */
    void deleteRunOptimalInfo(String id);

}
