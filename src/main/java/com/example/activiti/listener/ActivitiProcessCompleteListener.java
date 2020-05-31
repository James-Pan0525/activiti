package com.example.activiti.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

/**
 * @Description 流程结束监听器
 * @Date 22:44 2019/11/27
 * @Param
 * @return
 **/
public class ActivitiProcessCompleteListener implements ActivitiEventListener {

    @Override
    public void onEvent(ActivitiEvent activitiEvent) {
        //todo
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
