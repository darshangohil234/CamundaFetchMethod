package com.example.config;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Collections;
import com.example.utils.*;

@Component
public class BearerTokenGeneratorConfig {
    private static Logger logger = LoggerFactory.getLogger(BearerTokenGeneratorConfig.class);

         public String generateBearerToken() throws IOException {

            logger.info("Generating Bearer Token....!!");

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> tokenRequestBody = new LinkedMultiValueMap<String, String>();

            HttpEntity request = new HttpEntity(tokenRequestBody, headers);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.set(BearerTokenUtils.GRANT_TYPE , BearerTokenUtils.GRANT_TYPEVALUE);
            headers.set(BearerTokenUtils.CLIENT_ID, BearerTokenUtils.CLIENT_IDVALUE);
         
            headers.set(BearerTokenUtils.CLIENT_SECRET_KEY, BearerTokenUtils.CLIENT_SECRET_KEYVALUE);
            headers.set(GlobalUtils.GlobalUtilHeaders.CONTENT_TYPE, BearerTokenUtils.CONTENTTYPEVALUE);
            tokenRequestBody.add(BearerTokenUtils.GRANT_TYPE, BearerTokenUtils.GRANT_TYPEVALUE); ;
            tokenRequestBody.add(BearerTokenUtils.CLIENT_ID, BearerTokenUtils.CLIENT_IDVALUE);
            tokenRequestBody.add(BearerTokenUtils.CLIENT_SECRET_KEY, BearerTokenUtils.CLIENT_SECRET_KEYVALUE);
            ResponseEntity<String> response = restTemplate.exchange(BearerTokenUtils.BEARERTOKENURL, HttpMethod.POST, request, String.class);
            JSONObject bearerTokenAccessKey = new JSONObject(response.getBody());

            try {
                return bearerTokenAccessKey.getString("access_token");
            } catch (Exception e) {
                throw new IOException("Bearer Token Generator Service failed to generate access_token..!!");
            }
        }
    }
    
