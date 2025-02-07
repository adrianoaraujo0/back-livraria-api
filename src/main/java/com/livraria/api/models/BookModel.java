package com.livraria.api.models;


import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class BookModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(unique = true)
	private String name;
	
	@Column
	private String author;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDate release;
	
	@Column
	private int quantity;

	@Column
	private int totalRented;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", nullable = false)
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", release=" + release + ", quantity="
				+ quantity + ", totalRented=" + totalRented + ", publisher=" + publisher + "]";
	}
}
