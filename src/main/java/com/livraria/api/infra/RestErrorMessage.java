package com.livraria.api.infra;

import org.springframework.http.HttpStatus;

public class RestErrorMessage {
	
	String message;
	HttpStatus status;
	
	
	public RestErrorMessage(HttpStatus status, String message) {
		super();
		this.message = message;
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public HttpStatus getStatus() {
		return status;
	}


	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	

}
