package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Represents the details needed for genericRespnse.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericResponseData<T> {

	/**
	 * The message of the GenericResponse.
	 * This field is used for store message.
	 */
	private String message;

	/**
	 * The message of the responseData.
	 * This field is used for store generic respnseData.
	 */
	private T responseData;

}
