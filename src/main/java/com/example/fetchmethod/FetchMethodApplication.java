package com.example.fetchmethod;

import io.camunda.zeebe.spring.client.annotation.Deployment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * FetchMethodApplication is the entry point ogf the spring boot application.
 * This class contains the main method which is used to run the application.
 * <p>  @author Darshan Gohil  </p>
 */
@SpringBootApplication
@Deployment(resources = "classpath:UserTask.bpmn")
public class FetchMethodApplication {

	/**
	 * The main that starts the spring boot application.
	 *
	 * @param args command-line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(FetchMethodApplication.class, args);
	}

}
