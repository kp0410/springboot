/** 
 * @file: PipeNetworkRunService.java 
 * @Package： com.ywjs.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月22日 下午2:56:49 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.service;

import java.util.List;

import com.ywjs.model.entity.EarlyWarning;

/**
 * 
 * @ClassName PipeNetworkRunService
 * @Description TODO(管网运行接口) 
 * @Author 周伟
 * @Date 2019年11月22日 下午2:57:07
 */
public interface PipeNetworkRunService {

    /**
     * @Description: TODO(存储预报警及案例库信息) 
     * @author： 2019年11月22日  周伟  创建初始版本
     * @param earlyWarning
     */
    void saveEarlyWarning(EarlyWarning earlyWarning);

    /**
     * @Description: TODO(查询预报警及案例库信息) 
     * @author： 2019年11月22日  周伟  创建初始版本
     * @return
     */
    List<EarlyWarning> getEarlyWarning();

    /**
     * @Description: TODO(批量删除) 
     * @author： 2019年11月23日  周伟  创建初始版本
     * @param ids 预报警ID数组
     * @return
     */
    void deleteBatchEarlyWarning(Long[] ids);

}
