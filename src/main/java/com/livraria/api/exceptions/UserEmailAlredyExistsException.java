package com.livraria.api.exceptions;

public class UserEmailAlredyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserEmailAlredyExistsException() {super("O email inserido já existe");};
	
}
