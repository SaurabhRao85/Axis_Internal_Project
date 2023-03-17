package com.axis.exception;

public class HolderNameNotFoundException extends RuntimeException {

	String errorMsg;

	public HolderNameNotFoundException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
}
