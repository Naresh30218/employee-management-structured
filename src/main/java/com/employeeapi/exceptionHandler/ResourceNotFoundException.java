package com.employeeapi.exceptionHandler;

public class ResourceNotFoundException extends Exception{
	String errorMessage;
	
	public ResourceNotFoundException(String errorMessage) {
		super(String.format("Found with : %s", errorMessage));
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
