package com.axis.exception;

public class InValidIncomeException extends RuntimeException{

	String errorMsg;

	public InValidIncomeException(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
