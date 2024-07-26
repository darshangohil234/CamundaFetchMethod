package com.example.pojo;


public class FetchResponseData<T> {
	
	private String message;
	private T responseData;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponseData() {
		return responseData;
	}

	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}

	public FetchResponseData(String message, T responseData) {
		this.message = message;
		this.responseData = responseData;
	}

	public FetchResponseData() {
		super();
	}

}
