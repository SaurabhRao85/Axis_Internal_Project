package com.axis.exception;

public class CardStatusException extends RuntimeException {

	String errorMsg;

	public CardStatusException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}
	
}
