package com.livraria.api.exceptions;

public class RentDateAfterDateNowException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RentDateAfterDateNowException() {
		super("A data de aluguel não pode ser depois a data atual!");
	}
	
}
