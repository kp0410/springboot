package com.ywjs.websocket;

import com.google.gson.Gson;
import com.ywjs.common.enums.WebSorcketTypeEnum;
import com.ywjs.job.GetRealTimeSimulationResultJob;
import com.ywjs.job.GetRealtimeNodePipesimResultJob;
import com.ywjs.model.dto.WebSocketparam;
import com.ywjs.pythontookit.controller.GetRealtimeBranchPipesim;
import com.ywjs.pythontookit.controller.GetRealtimeNodePipesim;
import com.ywjs.service.TimedTaskService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ServerEndpoint 注解是一个类层次的注解，它的功能主要是将目前的类定义成一个websocket服务器端,
 * 注解的值将被用于监听用户连接的终端访问URL地址,客户端可以通过这个URL来连接到WebSocket服务器端
 * <p>
 * 即请求地址如： ws://localhost:8989/websocket访问该服务端
 * flag标志：0代表数据推送展示；1代表水合物分析
 */
@Service
@ServerEndpoint("/websocket/{flag}")
public class WebSocketService implements ApplicationContextAware {

    // 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    // concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    public static CopyOnWriteArraySet<WebSocketService> webSocketSet = new CopyOnWriteArraySet<WebSocketService>();

    // 实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    private static Map<Session, WebSocketService> webSocketMap = new HashMap<>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    // 定时任务Service
    // @Autowired  该注解在@ServerEndpoint注解的类中不能使用
    // static TimingService timingService; // 该定时有首次执行延迟问题
    static TimedTaskService timedTaskService;

    /**
     * 上下文对象实例
     */
    private static ApplicationContext applicationContext;
    //李鹏程 管段结果实时数据获取

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public WebSocketService() {
        // 初始化定时任务对象
        if (timedTaskService == null && applicationContext != null) {
            timedTaskService = (TimedTaskService) applicationContext.getBean("timedTaskService");
        }
    }

    /**
     * 连接建立成功调用的方法
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("flag") String flag,Session session) throws IOException {
        this.session = session;
        if (flag != null){
            if (WebSorcketTypeEnum.HydratesAnalyze.getFlag().equals(flag)){ // 水合物分析，需将数据推送到指定客户端
                webSocketMap.put(session, this);
            } else if(WebSorcketTypeEnum.RealTimePush.getFlag().equals(flag)){ // 实时数据推送，需群发
                webSocketSet.add(this); // 加入set中
            }
        } else {
            sendMessage("参数有误");
        }

        addOnlineCount(); // 在线数加1
        System.out.println("有新连接加入！当前在线客户端为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(Session session) {
        //webSocketSet.remove(this); // 从set中删除
        // 从map中删除
        Iterator<Entry<Session, WebSocketService>> iterator = webSocketMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Session, WebSocketService> entry = iterator.next();
            Session s = entry.getKey();
            if (s.equals(session)) {
                iterator.remove();
                // 关闭定时任务
                timedTaskService.stopTask(session);
            }
        }
        subOnlineCount(); // 在线数减1
        System.out.println("有一连接关闭！当前在线客户端为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        // 判断之前是否开启过定时任务，开启过则关闭
        if(timedTaskService.getScheduledFutureBySession().get(message) != null){
            timedTaskService.stopTask(session);
        }
        Gson gson = new Gson();
        WebSocketparam ps = gson.fromJson(message, WebSocketparam.class);
        if ("1".equals(ps.getParamtype())) {
            //获取李鹏程管段实时模拟结果数据
            GetRealtimeBranchPipesim getRealtimeBranchPipesim = (GetRealtimeBranchPipesim) applicationContext.getBean("getRealtimeBranchPipesim");
            // 创建作业此线程
            GetRealTimeSimulationResultJob job = new GetRealTimeSimulationResultJob(getRealtimeBranchPipesim, ps.getPipeidlist(), this);
            // 添加并执行定时任务
            timedTaskService.startTask(session,job,0,60);
        } else if("2".equals(ps.getParamtype())){
            //获取李鹏程管段实时模拟结果数据,获取节点模拟结果
            GetRealtimeNodePipesim getRealtimeNodePipesim = (GetRealtimeNodePipesim) applicationContext.getBean("getRealtimeNodePipesim");
            // 创建作业此线程
            GetRealtimeNodePipesimResultJob job = new GetRealtimeNodePipesimResultJob(getRealtimeNodePipesim, ps.getElementNameList(), this);
            // 添加并执行定时任务
            timedTaskService.startTask(session,job,0,60);
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        //timingService.stopCron(session);
        timedTaskService.stopTask(session);
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        // this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketService.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketService.onlineCount--;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
