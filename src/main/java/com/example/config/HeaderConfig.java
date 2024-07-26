package com.example.config;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import com.example.utils.BearerTokenUtils;
import com.example.utils.GlobalUtils.GlobalUtilHeaders;

import lombok.SneakyThrows;

@Component
@Import(BearerTokenGeneratorConfig.class)
public class HeaderConfig {

	private static Logger logger = LoggerFactory.getLogger(HeaderConfig.class);
	
    private final BearerTokenGeneratorConfig bearerTokenGeneratorConfig;
    
    public HeaderConfig(BearerTokenGeneratorConfig bearerTokenGeneratorConfig) {
    	this.bearerTokenGeneratorConfig = bearerTokenGeneratorConfig;
    }

    @SneakyThrows
    public HttpHeaders addHeadersValue() throws IOException {
    	logger.info("Adding Header Values!!");
        HttpHeaders headers = new HttpHeaders();
        try {
        headers.set(GlobalUtilHeaders.ACCEPT, GlobalUtilHeaders.APPLICATIONJSON);
        headers.set(GlobalUtilHeaders.CONTENT_TYPE, GlobalUtilHeaders.APPLICATIONJSON);  
		headers.set(GlobalUtilHeaders.AUTHORIZATION, BearerTokenUtils.BEARER + bearerTokenGeneratorConfig.generateBearerToken());
        }catch (Exception ex) {
        	logger.error(ex.getMessage());
        	headers.set("Error", ex.getMessage());
        	return headers;
		}
		
		return headers;
    }
	
}
