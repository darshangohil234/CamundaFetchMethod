package com.example.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.pojo.TaskListVariableDetails;
import io.camunda.zeebe.client.ZeebeClient;
import lombok.SneakyThrows;

import static com.example.utils.GlobalUtils.GlobalZeebeUtils.SUCCESS;

import java.io.IOException;

public class StartWorkflow {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StartWorkflow.class);
	
	@Autowired
	ZeebeClient zeebeClient;
	
	@SneakyThrows
	public TaskListVariableDetails.TaskListVariableResponse startProcessInstance(String requestBody) throws IOException{
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
