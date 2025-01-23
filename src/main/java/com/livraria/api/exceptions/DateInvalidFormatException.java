package com.livraria.api.exceptions;

public class DateInvalidFormatException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	
	public DateInvalidFormatException() {
		super("Data inválida!");
	}
	

}
