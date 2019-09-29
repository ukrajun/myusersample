package com.devapp.ws.devappws.user.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = { DataValidationException.class })
	public ResponseEntity<Object> handleDataValidationEception(DataValidationException dve, WebRequest request) {
		
		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setErrorcode("P101");
		errorMessage.setErrorMessage("Email is required");
		
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
