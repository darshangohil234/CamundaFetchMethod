package com.example.Config;

import lombok.SneakyThrows;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.example.Utils.BearerTokenUtils;
import com.example.Utils.GlobalUtils.GlobalUtilHeaders;

@Component
@Import(BearerTokenGeneratorConfig.class)
public class HeaderConfig {


    @Autowired
	BearerTokenGeneratorConfig bearerTokenGeneratorConfig;

   // @Value("${application.json}")
    //private String applicationJson;

     @SneakyThrows
    public HttpHeaders addHeadersValue() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        //BearerTokenGeneratorConfig bearerTokenGeneratorConfig = new BearerTokenGeneratorConfig();
        headers.set(GlobalUtilHeaders.ACCEPT, GlobalUtilHeaders.APPLICATIONJSON);//applicationJson);
        headers.set(GlobalUtilHeaders.CONTENT_TYPE, GlobalUtilHeaders.APPLICATIONJSON);//applicationJson);  
		headers.set(GlobalUtilHeaders.AUTHORIZATION, BearerTokenUtils.BEARER + bearerTokenGeneratorConfig.generateBearerToken());
        return headers;
    }


	
}
