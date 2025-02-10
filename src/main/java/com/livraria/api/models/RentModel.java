package com.livraria.api.models;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class RentModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDate rentDate;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDate returnDate;
	
	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private LocalDate forecastDate;
	
	@ManyToOne
	@JoinColumn(name = "book_id", nullable = false)
	private BookModel book;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserModel user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getForecastDate() {
		return forecastDate;
	}

	public void setForecastDate(LocalDate forecastDate) {
		this.forecastDate = forecastDate;
	}

	public BookModel getBook() {
		return book;
	}

	public void setBook(BookModel book) {
		this.book = book;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RentModel [id=" + id + ", rentDate=" + rentDate + ", returnDate=" + returnDate + ", forecastDate="
				+ forecastDate + ", book=" + book + ", user=" + user + "]";
	}
	
	

	
	
}
