package com.ywjs.job;

import com.ywjs.common.utils.ObjectUtil;
import com.ywjs.model.dto.ElementName;
import com.ywjs.pythontookit.controller.GetRealtimeNodePipesim;
import com.ywjs.websocket.WebSocketService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 实时数据模拟结果分析job
 * @author zhouwei
 * @create 2019-12-11 14:10
 */
public class GetRealtimeNodePipesimResultJob implements Runnable{

    private GetRealtimeNodePipesim getRealtimeNodePipesim;
    private List<ElementName> elementNameList;
    private WebSocketService webSocketService;

    public GetRealtimeNodePipesimResultJob(GetRealtimeNodePipesim getRealtimeNodePipesim, List<ElementName> elementNameList, WebSocketService webSocketService) {
        this.getRealtimeNodePipesim = getRealtimeNodePipesim;
        this.elementNameList = elementNameList;
        this.webSocketService = webSocketService;
    }

    @Override
    public void run() {
        // 获取当前系统时间减去10分钟
        Date date = new Date(System.currentTimeMillis() - 1000 * 60 * 2);
        Object result = getRealtimeNodePipesim.getNodeFzjg(date,elementNameList);
        try {
            // 将结果转化为json字符串
            String jsonData = ObjectUtil.mapper.writeValueAsString(result);
            // 将结果通过WebSorcket发送到前端
            webSocketService.getSession().getBasicRemote().sendText(jsonData);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
