package com.example.activiti.listener;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;

/** 任务完成的需要处理的逻辑
 */
public class ActivitiTaskCompleteListener implements ActivitiEventListener {


    @Override
    public void onEvent(ActivitiEvent activitiEvent) {
        //todo
    }

    @Override
    public boolean isFailOnException() {
        return false;
    }
}
