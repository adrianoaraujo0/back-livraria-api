package com.livraria.api.exceptions;

public class PublisherNameAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PublisherNameAlreadyExistsException() {
		super("O nome inserido já existe.");
	}

}
