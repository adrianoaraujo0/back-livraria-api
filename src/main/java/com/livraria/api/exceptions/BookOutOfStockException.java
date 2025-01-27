package com.livraria.api.exceptions;

public class BookOutOfStockException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public BookOutOfStockException() {
		super("Livro indisponível no estoque");
	}

	
	
}
