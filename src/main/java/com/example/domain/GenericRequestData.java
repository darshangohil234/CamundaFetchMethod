package com.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * Represents the details needed for genericRequest.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericRequestData<T> {

	/**
	 * The inputPayload of the GenericRequestData.
	 * This field is used for get input from @requestBody and also stored securely.
	 */
	private T inputPayload;

}
