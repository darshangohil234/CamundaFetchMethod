package com.example.service;

import java.io.IOException;
import java.util.*;
import io.camunda.zeebe.client.ZeebeClient;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.configuration.HeaderConfig;
import com.example.domain.GenericResponseData;
import com.example.utils.GlobalUtils.GlobalTasklistUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * TaskListServiceImpl is the main entity for TaskList Apis . . .
 * Please see the {@link com.example.service} class for true identity
 *  <p>  @author Darshan Gohil  </p>
 *
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TaskListServiceImpl {

	/**
	 * The public Client of a zeebe for Camunda tasklist apis
	 */
	private final ZeebeClient zeebeClient;

	/**
	 * The HeaderConfiguration for get Headers values from HeaderConfig
	 */
	private final HeaderConfig headerConfig;

	/**
	 * Retrieves all tasks from the task list.
	 * @param requestBody the request body to send with the HTTP request.
	 *
	 * @return a response containing a list of tasks.
	 * @throws IOException if an I/O error occurs.
	 */
	public GenericResponseData<List<Object>> getAllTask(Object requestBody) throws IOException {
		log.info("Service for GET A TASK FROM TASKLIST invoked..!!");
		GenericResponseData<List<Object>> responseData = new GenericResponseData<>();
		HttpHeaders headers = headerConfig.addHeadersValue();
		HttpEntity<Object> httpEntity = new HttpEntity<>(requestBody, headers);
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> response = restTemplate.exchange(GlobalTasklistUtils.TASKSEARCHURL, HttpMethod.POST, httpEntity, String.class);
			JSONArray arr = new JSONArray(response.getBody());
			log.info("Successfully get a tasks from TaskList..!!");
			responseData.setMessage("Success");
			responseData.setResponseData(arr.toList());
		} catch (Exception ex) {
			log.error("Error occurred: {}", ex.getMessage());
			responseData.setMessage("Error: " + ex.getMessage());
			return responseData;
		}
		return responseData;
	}

	/**
	 * Starts a new process instance.
	 *
	 * @return a response indicating the result of the operation.
	 * @throws IOException if an I/O error occurs.
	 */
	public GenericResponseData<List<Object>> start() throws IOException{
		log.info("Process Instance Start....!!");
		List<Object> respObj = new ArrayList<>();
		GenericResponseData<List<Object>> responseData = new GenericResponseData<>();
		try {
			var event = zeebeClient.newCreateInstanceCommand()
					.bpmnProcessId(GlobalTasklistUtils.PROCESSINSTANCEID)
					.latestVersion()
					.send()
					.join();

			responseData.setMessage("Success");
			respObj.add(event);
			responseData.setResponseData(respObj);
		}catch(Exception ex){
			log.error("Error occurred: {}", ex.getMessage());
			responseData.setMessage("Error: " + ex.getMessage());
			return responseData;
		}
		log.info("Process Instance Created Successfully....!!");
		return responseData;
	}
}
