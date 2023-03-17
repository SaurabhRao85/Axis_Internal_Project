package com.axis.exception;

public class PhoneNumberNotFoundException extends RuntimeException {

	String errorMsg;

	public PhoneNumberNotFoundException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
}
