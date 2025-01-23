package com.livraria.api.exceptions;

public class BookNameAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BookNameAlreadyExistsException() {
		super("Esse livro já existe.");
	}
	
}
