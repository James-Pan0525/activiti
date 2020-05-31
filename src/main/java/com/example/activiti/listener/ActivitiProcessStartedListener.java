package com.example.activiti.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

/**
 * @date 2019/11/21 19:54
 * @description: 流程启动监听器
 */
public class ActivitiProcessStartedListener implements ActivitiEventListener {


    /**
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
