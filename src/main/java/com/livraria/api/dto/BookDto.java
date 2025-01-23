package com.livraria.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.livraria.api.models.EditoraModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookDto {
	
	private int id;
	
	@NotBlank(message = "O nome do livro é obrigatório!")
	private String name;
	
	@NotBlank(message = "O nome do autor é obrigatório!")
	private String author;
	
    @NotNull(message = "A data de lançamento é obrigatória!")
    @JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate release;
	
	@NotBlank(message = "A quantidade de livros é obrigátoria!")
	private String quantity;

	@NotNull(message = "O número total de livros vendidos é obrigatório")
	private int totalRented;
	
	@NotNull(message = "Escolha uma editora!")
	private EditoraModel publisher;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDate getRelease() {
		return release;
	}

	public void setRelease(LocalDate release) {
		this.release = release;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public int getTotalRented() {
		return totalRented;
	}

	public void setTotalRented(int totalRented) {
		this.totalRented = totalRented;
	}

	public EditoraModel getPublisher() {
		return publisher;
	}

	public void setPublisher(EditoraModel publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookDto [name=" + name + ", author=" + author + ", release=" + release + ", quantity=" + quantity
				+ ", totalRented=" + totalRented + ", publisher=" + publisher + "]";
	}
	
	
	

}
