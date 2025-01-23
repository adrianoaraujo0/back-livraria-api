package com.livraria.api.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EditoraModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public EditoraModel(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String nome;
	
	@Column
	private String cidade;

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "EditoraModel [id=" + id + ", nome=" + nome + ", cidade=" + cidade + "]";
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	

}
