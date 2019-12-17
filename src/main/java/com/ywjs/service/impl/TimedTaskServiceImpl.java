package com.ywjs.service.impl;

import com.ywjs.service.TimedTaskService;
import org.springframework.stereotype.Service;

import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 定时任务实现
 * @author zhouwei
 * @create 2019-12-07 17:32
 */
@Service("timedTaskService")
public class TimedTaskServiceImpl implements TimedTaskService {

    //@Autowired
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
    private ScheduledFuture<?> future;
    private Map<Session, ScheduledFuture> futureMap = new HashMap<>(); //new ConcurrentHashMap<>();中键值对不能为null

//    @Bean
//    public ScheduledExecutorService threadPoolTaskScheduler() {
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
//        return scheduler;
//    }

    @Override
    public Map<Session, ScheduledFuture> getScheduledFutureBySession() {
        return futureMap;
    }

    @Override
    public boolean startTask(Runnable runnable, long inittialDelay, long period) {
        future = scheduler.scheduleAtFixedRate(runnable, inittialDelay, period, TimeUnit.SECONDS);
        return true;
    }

    @Override
    public boolean startTask(Session session, Runnable runnable,long inittialDelay,long period) {
        future = scheduler.scheduleAtFixedRate(runnable, inittialDelay, period, TimeUnit.SECONDS);
        futureMap.put(session, future);
        return true;
    }

    @Override
    public boolean stopTask(Session session) {
        futureMap.get(session).cancel(true);
        return true;
    }

    @Override
    public boolean updateTask(Session session,Runnable runnable, long initialDelay, long period) {
        stopTask(session);// 先停止，在开启.
        future = scheduler.scheduleAtFixedRate(runnable, initialDelay, period, TimeUnit.SECONDS);
        // 覆盖之前的任务
        futureMap.put(session, future);
        return true;
    }
}
