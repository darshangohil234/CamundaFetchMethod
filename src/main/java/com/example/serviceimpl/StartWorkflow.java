package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pojo.TaskListVariableDetails;
import io.camunda.zeebe.client.ZeebeClient;
import static com.example.utils.GlobalUtils.GlobalZeebeUtils.SUCCESS;

public class StartWorkflow {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StartWorkflow.class);
	
	@Autowired
	ZeebeClient zeebeClient;
	
	public TaskListVariableDetails.TaskListVariableResponse startProcessInstance(String requestBody) throws Exception{
	    log.info("Start workflow start..!!");
		TaskListVariableDetails.TaskListVariableResponse taskListResponse = new TaskListVariableDetails.TaskListVariableResponse();
	    try {
	        zeebeClient
	                .newCreateInstanceCommand()
	                .bpmnProcessId("Process_0pukv4e")
	                .latestVersion()
	                .send()
	                .join();
	    }catch(Exception ex){	       
	        taskListResponse.setMessage("Error " + ex.getMessage());
	        return taskListResponse;
	    }
	    taskListResponse.setMessage(SUCCESS);
	    return taskListResponse;
	}
}
