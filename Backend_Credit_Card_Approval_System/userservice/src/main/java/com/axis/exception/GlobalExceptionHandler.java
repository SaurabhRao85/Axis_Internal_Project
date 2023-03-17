package com.axis.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionResponse(IdNotFoundException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(exception.getErrorMsg());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ErrorInfo>(errorInfo , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PhoneNumberNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionResponse(PhoneNumberNotFoundException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(exception.getErrorMsg());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ErrorInfo>(errorInfo , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(HolderNameNotFoundException.class)
	ResponseEntity<ErrorInfo> myExceptionResponse(HolderNameNotFoundException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(exception.getErrorMsg());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ErrorInfo>(errorInfo , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InValidCityException.class)
	ResponseEntity<ErrorInfo> myExceptionResponse(InValidCityException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(exception.getErrorMsg());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ErrorInfo>(errorInfo , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InValidIncomeException.class)
	ResponseEntity<ErrorInfo> myExceptionResponse(InValidIncomeException exception)
	{
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setStatus(HttpStatus.NOT_FOUND.toString());
		errorInfo.setErrorMessage(exception.getErrorMsg());
		errorInfo.setLocalDateTime(LocalDateTime.now());
		
		
		return new ResponseEntity<ErrorInfo>(errorInfo , HttpStatus.NOT_FOUND);
	}
}
