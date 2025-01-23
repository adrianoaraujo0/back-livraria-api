package com.livraria.api.exceptions;

public class PublisherNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PublisherNotFoundException() {
		super("Editora não encontrada");
	}
	
}
