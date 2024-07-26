package com.example.pojo;

import org.springframework.stereotype.Component;

@Component
public class FetchRequestData<T> {

	private T inputPayload;

	public FetchRequestData() {
		super();
	}

	public FetchRequestData(T inputPayload) {
		this.inputPayload = inputPayload;
	}

	public T getInputPayload() {
		return inputPayload;
	}

	public void setInputPayload(T inputPayload) {
		this.inputPayload = inputPayload;
	}

}
