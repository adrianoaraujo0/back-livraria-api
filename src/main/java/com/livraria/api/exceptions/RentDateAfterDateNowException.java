package com.livraria.api.exceptions;

public class RentDateAfterDateNowException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RentDateAfterDateNowException() {
		super("A data não pode ser anterior a data atual!");
	}
	
}
