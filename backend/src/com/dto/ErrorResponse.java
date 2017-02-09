package com.dto;

public class ErrorResponse {

	private int status;
	private String message;
	
	
	public ErrorResponse(int statusCode, String message) {
		this.setStatus(statusCode);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
