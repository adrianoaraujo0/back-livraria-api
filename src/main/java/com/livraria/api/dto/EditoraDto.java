package com.livraria.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EditoraDto {

	@NotBlank(message = "O nome da cidade é obrigatório.")
	@NotNull(message = "Esse campo não pode ser nulo.")
	private String cidade;
	
	@NotBlank(message = "O nome da editora é obrigatório.")
	@NotNull(message = "Esse campo não pode ser nulo.")
	private String nome;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
