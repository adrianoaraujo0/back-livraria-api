package com.livraria.api.exceptions;

public class RentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RentNotFoundException() {
		super("Aluguel não encontrado.");
	}
	
}
