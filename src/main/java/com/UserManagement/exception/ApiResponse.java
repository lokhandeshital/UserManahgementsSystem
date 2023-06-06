package com.UserManagement.exception;

public class ApiResponse {

	private String message;
	
	private String errorcode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	@Override
	public String toString() {
		return "ApiResponse [message=" + message + ", errorcode=" + errorcode + "]";
	}

	public ApiResponse(String message, String errorcode) {
		super();
		this.message = message;
		this.errorcode = errorcode;
	}

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
