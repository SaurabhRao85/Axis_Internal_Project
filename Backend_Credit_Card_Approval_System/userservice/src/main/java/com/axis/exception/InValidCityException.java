package com.axis.exception;

public class InValidCityException extends RuntimeException {
	String errorMsg;

	public InValidCityException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
