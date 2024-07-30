package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Represents the details needed for generating a bearer token.
 */
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BearerTokenGeneratorDetails {

    /**
     * Represents the response containing the bearer token.
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BearerTokenGeneratorResponse {

        /**
         * The accessToken of the BearerTokenGeneratorDetails.
         * This field is used for generated access token should be securely stored.
         */
        private String accessToken;
    }
}