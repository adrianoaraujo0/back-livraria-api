package com.livraria.api.exceptions;

public class DateIsAfterDateNowException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DateIsAfterDateNowException() {
		super("A data de lançamento deve ser antes da data atual.");
	}

}
