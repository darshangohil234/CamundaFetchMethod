package com.example.configuration;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import com.example.utils.BearerTokenUtils;
import com.example.utils.GlobalUtils.GlobalUtilHeaders;

/**
 * HeaderConfig is responsible for adding and storing all header values in HttpHeaders.
 * Please see the {@link com.example.configuration.HeaderConfig} class for more details.
 *
 * <p>Author: Darshan Gohil</p>
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class HeaderConfig {

    private final BearerTokenGeneratorConfig bearerTokenGeneratorConfig;

    /**
     * Adds header values into the HttpHeaders.
     *
     * @return HttpHeaders containing the header values.
     * @throws IOException if an I/O error occurs.
     */
    @Bean
    public HttpHeaders addHeadersValue() throws IOException {
        log.info("Adding Header Values Start....!!");
        HttpHeaders headers = new HttpHeaders();
        try {
            headers.set(GlobalUtilHeaders.ACCEPT, GlobalUtilHeaders.APPLICATIONJSON);
            headers.set(GlobalUtilHeaders.CONTENT_TYPE, GlobalUtilHeaders.APPLICATIONJSON);
            headers.set(GlobalUtilHeaders.AUTHORIZATION, BearerTokenUtils.BEARER + bearerTokenGeneratorConfig.generateBearerToken());
        } catch (Exception ex) {
            log.error("Error occurred: {}", ex.getMessage());
            headers.set("Error", ex.getMessage());
            return headers;
        }
        log.info("Adding Header Values Successfully Done....!!");
        return headers;
    }
}

 