package com.axis.exception;

public class InValidDailyLimitException extends RuntimeException {

	
	String errorMsg;

	public InValidDailyLimitException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
