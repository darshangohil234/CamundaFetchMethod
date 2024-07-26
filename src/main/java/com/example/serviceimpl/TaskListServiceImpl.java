package com.example.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.config.HeaderConfig;
import com.example.pojo.FetchResponseData;
import com.example.utils.GlobalUtils.GlobalTasklistUtils;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@Import(HeaderConfig.class)
public class TaskListServiceImpl {
	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(TaskListServiceImpl.class);

	private final HeaderConfig headerConfig;
	
	public TaskListServiceImpl(HeaderConfig headerConfig) {
		this.headerConfig = headerConfig;
	}
	
	@SneakyThrows
	public FetchResponseData<List<Object>> getAllTask(Object requestBody) throws IOException {
		log.info("Service for GET A TASK FROM TASKLIST invoked..!!");
		List<Object> respObj = new ArrayList<>();
		FetchResponseData<List<Object>> responseData = new FetchResponseData<>(); 
		HttpHeaders headers = headerConfig.addHeadersValue();
		HttpEntity<String> httpEntity = new HttpEntity(requestBody, headers);		
		RestTemplate restTemplate = new RestTemplate();
		try {
			ResponseEntity<String> response = restTemplate.exchange(GlobalTasklistUtils.TASKSEARCHURL, HttpMethod.POST, httpEntity,
					String.class); 
		
			respObj.add(response.getBody());
			responseData.setMessage("Success");
			responseData.setResponseData(respObj);
			log.info(responseData.toString());
		} catch (Exception ex) {
			log.error(ex.toString());
			responseData.setMessage("Error: "+ ex.toString());
			return responseData;
		}
		return responseData;
	}

}
