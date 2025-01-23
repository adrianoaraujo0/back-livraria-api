package com.livraria.api.exceptions;

public class PublisherCannotBeDeletedException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PublisherCannotBeDeletedException(){
		super("Essa editora não pode ser excluída. Ela está associada a um livro.");
	}
	
}
