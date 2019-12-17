package com.ywjs.job;

import com.ywjs.common.utils.ObjectUtil;
import com.ywjs.model.dto.PiPeidList;
import com.ywjs.pythontookit.controller.GetRealtimeBranchPipesim;
import com.ywjs.websocket.WebSocketService;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 实时数据模拟job
 * @author zhouwei
 * @create 2019-12-06 15:58
 */
public class GetRealTimeSimulationResultJob implements Runnable{
    private GetRealtimeBranchPipesim getRealtimeBranchPipesim;
    private List<PiPeidList> piPeidList;
    private WebSocketService webSocketService;


    public GetRealTimeSimulationResultJob(GetRealtimeBranchPipesim getRealtimeBranchPipesim, List<PiPeidList> piPeidList, WebSocketService webSocketService) {
        this.getRealtimeBranchPipesim = getRealtimeBranchPipesim;
        this.piPeidList = piPeidList;
        this.webSocketService = webSocketService;
    }

    @Override
    public void run() {
        // 获取当前系统时间减去10分钟
        Date date = new Date(System.currentTimeMillis() - 1000 * 60 * 2);
        Object result = getRealtimeBranchPipesim.getPipeFzjg(date, piPeidList);
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
