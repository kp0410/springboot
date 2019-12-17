///**
// * @file: TimingServiceImpl.java
// * @Package： com.ywjs.service.impl
// * @Description: TODO(用一句话描述该文件做什么)
// * @author： 周伟
// * @date： 2019年12月2日 下午2:18:15
// * @version： V1.0
// * @par 版权信息：
// * 		2019 Copyright 北京鑫远望景盛展科技有限公司 All Rights Reserved.
// */
//package com.ywjs.service.impl;
//
//import com.ywjs.common.constant.CodeMsg;
//import com.ywjs.common.utils.GetRealTimeDataUtil;
//import com.ywjs.exception.GlobalException;
//import com.ywjs.job.GetRealTimeSimulationResultJob;
//import com.ywjs.job.RealTimeSimulationJob;
//import com.ywjs.model.dto.PiPeidList;
//import com.ywjs.model.vo.RealTiemSimulationVO;
//import com.ywjs.pythontookit.controller.GetRealtimeBranchPipesim;
//import com.ywjs.pythontookit.controller.GetRealtimePipesim;
//import com.ywjs.service.HttpClientService;
//import com.ywjs.service.TimingService;
//import com.ywjs.websocket.WebSocketService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Service;
//
//import javax.websocket.Session;
//import java.lang.reflect.Method;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ScheduledFuture;
//
///**
// * @ClassName TimingServiceImpl
// * @Description TODO(这里用一句话描述这个类的作用)
// * @Author 周伟
// * @Date 2019年12月2日 下午2:18:15
// */
//@Service("timingService")
//public class TimingServiceImpl implements TimingService {
//
//    @Autowired
//    HttpClientService client;
//    @Autowired
//    PipeNetworkModelServiceImpl pipeNetworkModelService;
//
//    @Autowired
//    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
//
//    private ScheduledFuture<?> future;
//
//    private Map<Session, ScheduledFuture> map = new HashMap<>();
//
//    // 初始化线程池
//    @Bean
//    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
//        ThreadPoolTaskScheduler executor = new ThreadPoolTaskScheduler();
//        executor.setPoolSize(20);
//        executor.setThreadNamePrefix("taskExecutor-");
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        executor.setAwaitTerminationSeconds(60);
//        return executor;
//    }
//
//    @Autowired
//    GetRealtimeBranchPipesim getRealtimeBranchPipesim;
//    @Override
//    public void startGetSimulationResult(Session session,String cron, List<PiPeidList> piPeidList, WebSocketService webSocketService) {
//        future = threadPoolTaskScheduler.schedule(new GetRealTimeSimulationResultJob(getRealtimeBranchPipesim,piPeidList,webSocketService), new CronTrigger(cron));
//        // 将定时任务加入map中管理
//        map.put(session,future);
//    }
//
//    @Autowired
//    GetRealTimeDataUtil getConfigValueUtil;
//    @Override
//    public void startRealTimeSimulation(String cron, List<RealTiemSimulationVO> list, GetRealtimePipesim getRealtimePipesim,Long id) {
//        future = threadPoolTaskScheduler.schedule(new RealTimeSimulationJob(getConfigValueUtil,list,getRealtimePipesim,id), new CronTrigger(cron));
//    }
//
//    /**
//     *
//     * @param <T>
//     * @param <E>
//     * @Description: TODO(开启定时任务)
//     * @author： 2019年12月2日  周伟  创建初始版本
//     * @param session 定时任务标识
//     * @param cron 定时任务cron表达式
//     * @return
//     */
//    public <T, E> void startCron(Session session, String cron, String
//            methodName, T parma,E  targetObj) {
//        // 测试暂时写死
//        future = threadPoolTaskScheduler.schedule(new MyRunnable(methodName, parma, targetObj), new CronTrigger(cron));
//        //future = threadPoolTaskScheduler.schedule(new MyRunnable(cron), new CronTrigger(cron));
//        map.put(session, future);
//    }
//
//    /**
//     *
//     * @Description: TODO(停止定时任务)
//     * @author： 2019年12月2日  周伟  创建初始版本
//     * @param session
//     * @return
//     */
//    public void stopCron(Session session) {
//        future = map.get(session);
//        future.cancel(true);
//    }
//
//    /**
//     *
//     * @Description: TODO(修改定时时间cron)
//     * @author： 2019年12月2日  周伟  创建初始版本
//     * @param session
//     * @param cron
//     * @return
//     */
//    public void updateCron(Session session,String cron) {
//        stopCron(session);// 先停止，在开启.
//        future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger(cron));
//        // 改变map中相应的值,存放相同的session会覆盖
//        map.put(session, future);
//    }
//
//    // 任务逻辑，可定制
//    private class MyRunnable<T, E> implements Runnable {
//
//        private String methodName;
//        private T parma;
//        private E  targetObj;
//        public MyRunnable() {
//        }
//
//        @SuppressWarnings("unused")
//        public MyRunnable(String methodName, T parma, E targetObj) {
//            this.methodName = methodName;
//            this.parma = parma;
//            this.targetObj = targetObj;
//        }
//
//        @Override
//        public void run() {
//            // 调用目标方法
//            callback( methodName, parma, targetObj);
//        }
//
//        /**
//         *
//         * @Description: TODO(这里用一句话描述这个方法的作用)
//         * @author： 2019年12月3日  周伟  创建初始版本
//         * @param methodName 目标方法名
//         * @param parma 目标方法参数
//         * @param targetObj 目标对象
//         */
//        public <T, E> void callback(String  methodName, T parma,E  targetObj)  {
//            try {
//                Method method = targetObj.getClass().getMethod(methodName, parma.getClass());
//                method.invoke(targetObj, parma);
//            } catch (Exception e) {
//                throw new GlobalException(CodeMsg.REFLECT_ERROR);
//            }
//
//        }
//
//
//    }
//
//
//    @Override
//    public Map<Session, ScheduledFuture> getScheduledFutureBySession() {
//        return map;
//    }
//}
