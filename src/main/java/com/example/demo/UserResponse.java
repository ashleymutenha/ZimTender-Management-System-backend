package com.example.demo;


public class UserResponse {
	
	private int responseCode;
	private Object response;

	public  UserResponse( int responseCode,Object response) {
		this.responseCode = responseCode;
		this.response = response;
	}

	public Object getResponse() {
		return response;
	}

	public void setResponse(Object response) {
		this.response = response;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

}
