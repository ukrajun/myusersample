package com.devapp.ws.devappws.user.exception;

public class ErrorMessage {
	private String Errorcode;
	private String ErrorMessage ;
	
	public String getErrorcode() {
		return Errorcode;
	}
	public void setErrorcode(String errorcode) {
		Errorcode = errorcode;
	}
	public String getErrorMessage() {
		return ErrorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		ErrorMessage = errorMessage;
	}
}
