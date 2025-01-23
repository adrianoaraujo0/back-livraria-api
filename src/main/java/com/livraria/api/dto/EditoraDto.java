package com.livraria.api.dto;

import jakarta.validation.constraints.NotBlank;

public class EditoraDto {

	@NotBlank
	private String cidade;
	
	@NotBlank
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
