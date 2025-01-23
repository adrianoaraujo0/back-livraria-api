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
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate release;
	
	@Column
	private String quantity;

	@Column
	private int totalRented;
	
	@ManyToOne
	@JoinColumn(name = "publisher_id", nullable = false)
	private EditoraModel publisher;

	public int getId() {
		System.out.println("1");
		return id;
	}

	public void setId(int id) {
		System.out.println("2");
		this.id = id;
	}

	public String getName() {
		System.out.println("3");
		return name;
	}

	public void setName(String name) {
		System.out.println("4");
		this.name = name;
	}

	public String getAuthor() {
		System.out.println("5");
		return author;
	}

	public void setAuthor(String author) {
		System.out.println("6");
		this.author = author;
	}

	public LocalDate getRelease() {
		System.out.println("7");
		return release;
	}

	public void setRelease(LocalDate release) {
		System.out.println("8");
		this.release = release;
	}

	public String getQuantity() {
		System.out.println("9");
		return quantity;
	}

	public void setQuantity(String quantity) {
		System.out.println("10");
		this.quantity = quantity;
	}

	public int getTotalRented() {
		System.out.println("11");
		return totalRented;
	}

	public void setTotalRented(int totalRented) {
		System.out.println("12");
		this.totalRented = totalRented;
	}

	public EditoraModel getPublisher() {
		System.out.println("13");
		return publisher;
	}

	public void setPublisher(EditoraModel publisher) {
		System.out.println("14");
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author + ", release=" + release + ", quantity="
				+ quantity + ", totalRented=" + totalRented + ", publisher=" + publisher + "]";
	}
	
	
	
	
}
