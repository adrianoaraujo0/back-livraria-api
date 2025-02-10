package com.livraria.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserModelDto {
	
	
	@NotBlank(message = "O nome do usuário é obrigatório.")
	@NotNull(message = "Esse campo não pode ser nulo.")
	private String name;
	
	@NotBlank(message = "O campo do email é obrigatório.")
	@NotNull(message = "Esse campo não pode ser nulo.")
	@Email(message = "Email inválido.")
	private String email;
	
	@NotBlank(message = "O campo do endereço é obrigatório.")
	@NotNull(message = "Esse campo não pode ser nulo.")
	private String endereco;
	
	@NotBlank(message = "O campo da cidade é obrigatório.")
	@NotNull(message = "Esse campo não pode ser nulo.")
	private String cidade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
	
	
}
