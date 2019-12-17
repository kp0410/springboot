/** 
 * @file: pipeNetworkRunOptimizePlanController.java 
 * @Package： com.ywjs.controller 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年11月25日 下午4:58:58 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ywjs.common.vo.Result;
import com.ywjs.model.entity.Operation;
import com.ywjs.model.entity.Optimize;
import com.ywjs.service.PipeNetworkRunOptimizePlanService;

/**
 * @ClassName pipeNetworkRunOptimizePlanController
 * @Description TODO(管网运行优化方案Controller) 
 * @Author 周伟
 * @Date 2019年11月25日 下午4:58:58
 */
@RestController
@RequestMapping("/yxyhglfa")
public class PipeNetworkRunOptimizePlanController {
    
    @Autowired
    PipeNetworkRunOptimizePlanService pipeNetworkRunOptimizePlanService;

    /**
     * 
     * @Description: TODO(获取运行方案优选信息) 
     * @author： 2019年11月26日  周伟  创建初始版本
     * @return
     */
    @RequestMapping("/getRunOptimizeInfo")
    public Result getRunOptimizeInfo(){
        List<Operation> listOperation = pipeNetworkRunOptimizePlanService.getRunOptimizeInfo();
        return Result.success(listOperation);
    }
    /**
     * 
     * @Description: TODO(删除运行方案优选信息) 
     * @author： 2019年11月26日  周伟  创建初始版本
     * @param ids
     * @return
     */
    @RequestMapping("/deleteBatchRunOptimize")
    public Result deleteBatchRunOptimize(Long[] ids){
        pipeNetworkRunOptimizePlanService.deleteBatchRunOptimize(ids);
        return Result.success();
    }
    /**
     * 
     * @Description: TODO(获取运行方案优化信息) 
     * @author： 2019年11月26日  周伟  创建初始版本
     * @return
     */
    @RequestMapping("/getRunOptimalInfo")
    public Result getRunOptimalInfo(){
        List<Optimize> listOperation = pipeNetworkRunOptimizePlanService.getRunOptimalInfo();
        return Result.success(listOperation);
    }
    /**
     * 
     * @Description: TODO(删除运行方案优化信息) 
     * @author： 2019年11月26日  周伟  创建初始版本
     * @param ids
     * @return
     */
    @RequestMapping("/deleteRunOptimalInfo")
    public Result deleteRunOptimalInfo(String id){
        pipeNetworkRunOptimizePlanService.deleteRunOptimalInfo(id);
        return Result.success();
    }

}
