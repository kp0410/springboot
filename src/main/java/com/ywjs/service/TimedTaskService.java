package com.ywjs.service;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * 定时任务管理接口
 * @author zhouwei
 * @create 2019-12-07 17:30
 */
public interface TimedTaskService {

    /**
     * 存放定时任务的容器
     */
    public Map<Session, ScheduledFuture> getScheduledFutureBySession();


    /**
     * 添加并启动一个定时任务
     * @param runnable 任务线程
     * @param inittialDelay 任务首次执行延时时间
     * @param period 任务周期
     * @return
     */
    public boolean startTask(Runnable runnable,long inittialDelay,long period) ;

    /**
     * 添加并启动一个定时任务
     * @param session  任务的唯一标识
     * @param runnable 任务线程
     * @param inittialDelay 任务首次执行延时时间
     * @param period 任务周期
     * @return
     */
    public boolean startTask(Session session,Runnable runnable,long inittialDelay,long period) ;

    /**
     * 根据标识关闭定时任务
     * @param session
     * @return
     */
    public boolean stopTask(Session session) ;

    /**
     * 根据标识修改任务
     * @param session 标识
     * @param initialDelay 任务第一次执行延时时间
     * @param period 任务执行间隔时间
     * @return
     */
    public boolean updateTask(Session session,Runnable runnable,long initialDelay,long period);



}
