/** 
 * @file: TimingService.java 
 * @Package： com.ywjs.service 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author： 周伟
 * @date： 2019年12月2日 下午2:17:07 
 * @version： V1.0 
 * @par 版权信息：
 * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
 */ 
package com.ywjs.service;

import com.ywjs.model.dto.PiPeidList;
import com.ywjs.model.vo.RealTiemSimulationVO;
import com.ywjs.pythontookit.controller.GetRealtimePipesim;
import com.ywjs.websocket.WebSocketService;

import javax.websocket.Session;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;


/**
 * @ClassName TimingService
 * @Description TODO(定时服务) 
 * @Author 周伟
 * @Date 2019年12月2日 下午2:17:07
 */
public interface TimingService {

    public Map<Session, ScheduledFuture> getScheduledFutureBySession();

    public void startGetSimulationResult(Session session,String cron, List<PiPeidList> pipeidlist, WebSocketService webSocketService);
    /**
     * @Description: TODO(实时仿真模拟)
     * @param cron cron表达式
     * @param list 实时数据
     * @param getRealtimePipesim  目标对象，调用实时仿真模拟计算
     * @param id
     */
    public void startRealTimeSimulation(String cron, List<RealTiemSimulationVO> list, GetRealtimePipesim getRealtimePipesim,Long id);
    
    /**
     * 
     * @Description: TODO(这里用一句话描述这个方法的作用) 
     * @author： 2019年12月3日  周伟  创建初始版本
     * @param session 任务标识
     * @param cron 定时任务cron表达式
     * @param methodName 目标方法名
     * @param parma 目标方法参数
     * @param targetObj 目标对象
     */
    public <T, E> void startCron(Session session, String cron, String 
            methodName, T parma,E  targetObj);
    /**
     * 
     * @Description: TODO(停止定时任务) 
     * @author： 2019年12月2日  周伟  创建初始版本
     * @param session
     * @return
     */
    public void stopCron(Session session);
    
    /**
     * 
     * @Description: TODO(修改定时时间cron) 
     * @author： 2019年12月2日  周伟  创建初始版本
     * @param session
     * @param cron
     * @return
     */
    public void updateCron(Session session,String cron);

}
