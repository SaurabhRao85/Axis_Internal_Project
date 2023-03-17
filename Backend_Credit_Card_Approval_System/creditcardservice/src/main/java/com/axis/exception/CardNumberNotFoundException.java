package com.axis.exception;

public class CardNumberNotFoundException extends RuntimeException {

	String errorMsg;

	public CardNumberNotFoundException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
}
