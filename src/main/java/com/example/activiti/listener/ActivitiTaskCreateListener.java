package com.example.activiti.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

/**
 * @description 任务创建监听器
 */
public class ActivitiTaskCreateListener implements ActivitiEventListener {


    /**
     * @Author Pan Weilong
     * @Description 存储节点任务
     * @Date 18:35 2019/12/5
     * @Param [activitiEvent]
     * @return void
     **/
    @Override
    public void onEvent(ActivitiEvent activitiEvent) {
        //todo
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
