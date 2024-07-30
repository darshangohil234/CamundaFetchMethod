package com.example.configuration;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.Collections;
import com.example.utils.*;

/**
 * BearerTokenGeneratorConfig is responsible for generating bearer tokens for Zeebe and tasklist APIs.
 * Please see the {@link com.example.configuration.BearerTokenGeneratorConfig} class for more details.
 * <p>Author: Darshan Gohil</p>
 */
@Slf4j
@Configuration
public class BearerTokenGeneratorConfig {

    /**
     * Bean for RestTemplate to be used for HTTP requests.
     *
     * @return a RestTemplate instance.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Retrieves token for Camunda APIs authentication.
     *
     * @return a generated bearer token.
     * @throws IOException if an I/O error occurs.
     */
    @Bean
    public String generateBearerToken() throws IOException {
        log.info("Generating Bearer Token Start....!!");

        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> tokenRequestBody = new LinkedMultiValueMap<>();

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set(BearerTokenUtils.GRANT_TYPE, BearerTokenUtils.GRANT_TYPEVALUE);
        headers.set(BearerTokenUtils.CLIENT_ID, BearerTokenUtils.CLIENT_IDVALUE);
        headers.set(BearerTokenUtils.CLIENT_SECRET_KEY, BearerTokenUtils.CLIENT_SECRET_KEYVALUE);
        headers.set(GlobalUtils.GlobalUtilHeaders.CONTENT_TYPE, BearerTokenUtils.CONTENTTYPEVALUE);

        tokenRequestBody.add(BearerTokenUtils.GRANT_TYPE, BearerTokenUtils.GRANT_TYPEVALUE);
        tokenRequestBody.add(BearerTokenUtils.CLIENT_ID, BearerTokenUtils.CLIENT_IDVALUE);
        tokenRequestBody.add(BearerTokenUtils.CLIENT_SECRET_KEY, BearerTokenUtils.CLIENT_SECRET_KEYVALUE);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(tokenRequestBody, headers);

        try {
            ResponseEntity<String> response = restTemplate().exchange(BearerTokenUtils.BEARERTOKENURL, HttpMethod.POST, request, String.class);
            JSONObject bearerTokenAccessKey = new JSONObject(response.getBody());
            log.info("Generating Bearer Token Successfully Done....!!");
            return bearerTokenAccessKey.getString("access_token");
        } catch (Exception ex) {
            log.error("Error occurred: {}", ex.getMessage());
            throw new IOException("Bearer Token Generator Service failed to generate access_token..!!", ex);
        }
    }
}
 
 