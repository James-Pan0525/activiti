

package com.example.activiti.config;

import com.example.activiti.listener.ActivitiProcessCompleteListener;
import com.example.activiti.listener.ActivitiProcessStartedListener;
import com.example.activiti.listener.ActivitiTaskCompleteListener;
import com.example.activiti.listener.ActivitiTaskCreateListener;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Configuration
public class ActivitiConfig {
	@Autowired
	private  DataSource dataSource;
	@Autowired
	private PlatformTransactionManager transactionManager;

	@Bean
	public SpringProcessEngineConfiguration getProcessEngineConfiguration() {
		SpringProcessEngineConfiguration config =
				new SpringProcessEngineConfiguration();
		// 流程图字体设置
		config.setActivityFontName("宋体");
		config.setAnnotationFontName("宋体");
		config.setLabelFontName("黑体");
		config.setDataSource(dataSource);
		config.setTransactionManager(transactionManager);
		config.setDatabaseType("mysql");
		//设置自动创建表
		config.setDatabaseSchemaUpdate("true");
		//springboot中配置全局监听类
		//流程启动监听器
		Map<String, List<ActivitiEventListener>> typedListeners = new HashMap<>();
		List<ActivitiEventListener> activitiEventListener =new ArrayList<>();
		activitiEventListener.add(getActivitiProcessStartedListener());
		typedListeners.put("PROCESS_STARTED", activitiEventListener);
		//任务创建监听
		List<ActivitiEventListener> activitiTaskCreateEventListener = new ArrayList<>();
		activitiTaskCreateEventListener.add(getActivitiTaskCreateListener());
		typedListeners.put("TASK_CREATED", activitiTaskCreateEventListener);
		//任务完成监听
		List<ActivitiEventListener> activitiTaskCompletedEventListener = new ArrayList<>();
		activitiTaskCompletedEventListener.add(getActivitiTaskCompleteListener());
		typedListeners.put("TASK_COMPLETED", activitiTaskCompletedEventListener);
		//流程结束监听
		List<ActivitiEventListener> activitiProcessCompletedEventListener = new ArrayList<>();
		activitiProcessCompletedEventListener.add(getActivitiProcessCompleteListener());
		typedListeners.put("PROCESS_COMPLETED", activitiProcessCompletedEventListener);
		config.setTypedEventListeners(typedListeners);
		return config;
	}

	@Bean
	@Primary
	public TaskExecutor primaryTaskExecutor() {
		return new ThreadPoolTaskExecutor();
	}

	@Bean
	public ActivitiProcessStartedListener getActivitiProcessStartedListener(){
		return new ActivitiProcessStartedListener();
	}

	@Bean
	public ActivitiTaskCreateListener getActivitiTaskCreateListener(){
		return new ActivitiTaskCreateListener();
	}

	@Bean
	public ActivitiTaskCompleteListener getActivitiTaskCompleteListener(){
		return new ActivitiTaskCompleteListener();
	}

	@Bean
	public ActivitiProcessCompleteListener getActivitiProcessCompleteListener(){
		return new ActivitiProcessCompleteListener();
	}

}
