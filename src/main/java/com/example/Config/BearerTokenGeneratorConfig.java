package com.example.Config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import com.example.POJO.*;
import com.example.Utils.*;
import com.example.POJO.BearerTokenGeneratorDetails;

import java.util.Collections;

@Component
@Slf4j
public class BearerTokenGeneratorConfig {
    private static Logger logger = LoggerFactory.getLogger(BearerTokenGeneratorConfig.class);

         public String generateBearerToken() throws IOException {

            logger.debug("Generating Bearer Token....!!");

            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            MultiValueMap<String, String> tokenRequestBody = new LinkedMultiValueMap<String, String>();

            HttpEntity request = new HttpEntity(tokenRequestBody, headers);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            headers.set(BearerTokenUtils.GRANT_TYPE , BearerTokenUtils.GRANT_TYPEVALUE);//grantType);
            headers.set(BearerTokenUtils.CLIENT_ID, BearerTokenUtils.CLIENT_IDVALUE);//clientId);
         
            headers.set(BearerTokenUtils.CLIENT_SECRET_KEY, BearerTokenUtils.CLIENT_SECRET_KEYVALUE);//clientSecret);
            headers.set(GlobalUtils.GlobalUtilHeaders.CONTENT_TYPE, BearerTokenUtils.CONTENTTYPEVALUE); //contentTypeEncoded);
            tokenRequestBody.add(BearerTokenUtils.GRANT_TYPE, BearerTokenUtils.GRANT_TYPEVALUE); //grantType);
            tokenRequestBody.add(BearerTokenUtils.CLIENT_ID, BearerTokenUtils.CLIENT_IDVALUE);//clientId);
            tokenRequestBody.add(BearerTokenUtils.CLIENT_SECRET_KEY, BearerTokenUtils.CLIENT_SECRET_KEYVALUE);//clientSecret);
            ResponseEntity<String> response = restTemplate.exchange(BearerTokenUtils.BEARERTOKENURL, HttpMethod.POST, request, String.class);
            JSONObject bearerTokenAccessKey = new JSONObject(response.getBody());

            try {
                return bearerTokenAccessKey.getString("access_token");
            } catch (Exception e) {
                throw new IOException("Bearer Token Generator Service failed to generate access_token..!!");
            }
        }
    }
     

  /*  @SneakyThrows
    public String generateBearerToken() throws JsonMappingException, JsonProcessingException {

        logger.debug("Generating Bearer Token....!!");

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> tokenRequestBody = new LinkedMultiValueMap<String, String>();
        
        HttpEntity request = new HttpEntity(tokenRequestBody, headers);
        BearerTokenGeneratorDetails.BearerTokenGeneratorResponse bearerTokenGeneratorResponse = new BearerTokenGeneratorDetails.BearerTokenGeneratorResponse();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(BearerTokenUtils.GRANT_TYPE ,grantType);
        headers.set(BearerTokenUtils.CLIENT_ID, clientId);
        headers.set(BearerTokenUtils.CLIENT_SECRET_KEY,clientSecret);
        headers.set(GlobalUtils.GlobalUtilHeaders.CONTENT_TYPE,contentTypeEncoded);
        tokenRequestBody.add(BearerTokenUtils.GRANT_TYPE, grantType);
        tokenRequestBody.add(BearerTokenUtils.CLIENT_ID, clientId);
        tokenRequestBody.add(BearerTokenUtils.CLIENT_SECRET_KEY,clientSecret);

        ResponseEntity<String> response = restTemplate.exchange(bearerTokenUrl, HttpMethod.POST, request, String.class);
        ObjectMapper objectMapper = new ObjectMapper();      
        JsonNode readingResponse = objectMapper.readTree(response.getBody());
        bearerTokenGeneratorResponse.setAccessToken(readingResponse.get(GlobalUtils.GlobalUtilHeaders.ACCESSTOKEN).asText());
        try {
            System.out.println(bearerTokenGeneratorResponse.getAccessToken());
            return bearerTokenGeneratorResponse.getAccessToken();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    
    
