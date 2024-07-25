package com.example.ServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.Config.HeaderConfig;
import com.example.POJO.FetchTaskRequest;
import com.example.POJO.FetchTaskResp;
import com.example.POJO.TaskListVariableDetails;
import com.example.Utils.GlobalUtils.GlobalTasklistUtils;

import ch.qos.logback.classic.Logger;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Import(HeaderConfig.class)
public class TaskListServiceImpl {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TaskListServiceImpl.class);

	@Autowired
	private HeaderConfig headerConfig;
	
	@Autowired
	private FetchTaskResp fetchTaskResp; 

	@SneakyThrows
	public List<FetchTaskResp> getAllTask(Object requestBody) throws IOException {

		System.out.println("Service for GET A TASK FROM TASKLIST invoked..!!");
		List<FetchTaskResp> fetchData = new ArrayList<>(); 
		TaskListVariableDetails.TaskListVariableResponse taskListVariableResponse = new TaskListVariableDetails.TaskListVariableResponse();
		HttpHeaders headers = headerConfig.addHeadersValue();
		HttpEntity<String> httpEntity = new HttpEntity(requestBody, headers);		
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> response = restTemplate.exchange(GlobalTasklistUtils.TASKSEARCHURL, HttpMethod.POST, httpEntity,
					String.class); 
		
			JSONArray arr = new JSONArray(response.getBody());
			   
			for (Object obj : arr) {
				try {
				JSONObject obj1 = new JSONObject(obj.toString());
				System.out.println(obj1);
				
				fetchTaskResp.setId(obj1.get("id").toString());
				fetchTaskResp.setIsFirst(obj1.get("isFirst").toString());
				fetchTaskResp.setName(obj1.get("name").toString());
				fetchTaskResp.setAssignee(obj1.get("assignee").toString());
				fetchTaskResp.setDueDate(obj1.get("dueDate").toString());
				fetchTaskResp.setProcessDefinitionKey(obj1.get("processDefinitionKey").toString());
				fetchTaskResp.setProcessInstanceKey(obj1.get("processInstanceKey").toString());
				fetchTaskResp.setCreationDate(obj1.get("creationDate").toString());
				fetchTaskResp.setFollowUpDate(obj1.get("followUpDate").toString());
				fetchTaskResp.setFormId(obj1.get("formId").toString());
				fetchTaskResp.setFormKey(obj1.get("formKey").toString());
				fetchTaskResp.setFormVersion(obj1.get("formVersion").toString());
				
				fetchData.add(fetchTaskResp);
				}catch(Exception ex) {
					log.error(ex.toString());
				}
				System.out.println(fetchData);
			}			
		} catch (Exception ex) {
			log.error(ex.toString());
			taskListVariableResponse.setMessage(ex.getMessage());
			return null;
		}
		return fetchData;
	}
}
