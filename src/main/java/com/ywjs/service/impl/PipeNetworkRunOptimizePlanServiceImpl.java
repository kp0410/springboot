/** 
 * @file: PipeNetworkRunOptimizePlanServiceImpl.java 
 * @Package： com.ywjs.service.impl 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月25日 下午5:10:57 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ywjs.mapper.OperationMapper;
import com.ywjs.mapper.OptimizeMapper;
import com.ywjs.model.entity.Operation;
import com.ywjs.model.entity.OperationExample;
import com.ywjs.model.entity.Optimize;
import com.ywjs.model.entity.OptimizeExample;
import com.ywjs.service.PipeNetworkRunOptimizePlanService;

/**
 * @ClassName PipeNetworkRunOptimizePlanServiceImpl
 * @Description TODO(这里用一句话描述这个类的作用) 
 * @Author 周伟
 * @Date 2019年11月25日 下午5:10:57
 */
@Service("pipeNetworkRunOptimizePlanService")
@Transactional(rollbackFor = Exception.class)
public class PipeNetworkRunOptimizePlanServiceImpl implements PipeNetworkRunOptimizePlanService{

    @Autowired
    OperationMapper operationMapper; //运行方案优选DAO
    @Autowired
    OptimizeMapper optimizeMapper; //运行方案优化DAO
    @Override
    public List<Operation> getRunOptimizeInfo() {
        OperationExample operationExample = new OperationExample();
        operationExample.setOrderByClause("OPERAID_OPERA desc");
        return operationMapper.selectByExample(operationExample);
    }

    @Override
    public void deleteBatchRunOptimize(Long[] ids) {
        if(ids != null && ids.length > 0){
            for (Long i : ids) {
                operationMapper.deleteByPrimaryKey(i);
            }
        }       
    }

    @Override
    public List<Optimize> getRunOptimalInfo() {
        OptimizeExample optimizeExample = new OptimizeExample();
        optimizeExample.setOrderByClause("CREATEDATE_OPTIM desc");
        return optimizeMapper.selectByExample(optimizeExample);
    }

    @Override
    public void deleteRunOptimalInfo(String id) {
        optimizeMapper.deleteByPrimaryKey(id);
    }
    
    

}
