package com.ywjs.listenner;

/**
 * @author zhouwei
 * @create 2019-12-11 13:55
 */

import com.ywjs.job.SimulationResultAnalysisJob;
import com.ywjs.mapper.ElementMapper;
import com.ywjs.mapper.PropertyValueMapper;
import com.ywjs.mapper.RealtimeSimulationMapper;
import com.ywjs.mapper.RealtimesimPipeResultMapper;
import com.ywjs.model.entity.Element;
import com.ywjs.model.entity.ElementExample;
import com.ywjs.model.entity.RealtimeSimulation;
import com.ywjs.service.TimedTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

//@Component
@Order(value = 1)
public class ScheduleJobInitListener implements CommandLineRunner {

    @Autowired
    TimedTaskService timedTaskService;
    @Autowired
    RealtimeSimulationMapper realtimeSimulationMapper;
    @Autowired
    ElementMapper elementMapper;
    @Autowired
    PropertyValueMapper propertyValueMapper;
    @Autowired
    RealtimesimPipeResultMapper realtimesimPipeResultMapper;


    @Override
    public void run(String... arg0) throws Exception {
        // 获取实时模拟最后条数据，需备份表id和工况id
        RealtimeSimulation realtimeSimulation = realtimeSimulationMapper.selectMax();
        // 读取设备，条件为设备类型为3的
        // 2.1 根据工程备份表ID获取元件拓扑表中的元件编号（管道），限制条件元件类型：3
        ElementExample elementExample = new ElementExample();
        elementExample.createCriteria().andProjectidProaffEqualTo(realtimeSimulation.getProjectidProaff())
                .andElementtypeEleEqualTo("3");
        List<Element> listElement = elementMapper.selectByExample(elementExample);
        // 调用定时任务，实时获取模拟数据
        // 创建作业此线程
        SimulationResultAnalysisJob job = new  SimulationResultAnalysisJob(realtimeSimulation,listElement,propertyValueMapper,realtimesimPipeResultMapper);
        // 添加并执行定时任务
        timedTaskService.startTask(job,0,60);
    }


}