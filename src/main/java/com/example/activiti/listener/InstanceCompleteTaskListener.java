package com.example.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

/**
 * @author Pan Weilong
 * @date 2019/11/26 10:11
 * @description: 节点完成条件 true表示完成  false表示未完成
 */
@Component("instanceCompleteTaskListener")
public class InstanceCompleteTaskListener{


    public boolean exec(DelegateExecution execution){
        return true;
    }
}
