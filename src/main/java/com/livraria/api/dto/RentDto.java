package com.livraria.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.api.models.BookModel;
import com.livraria.api.models.UserModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

public class RentDto {
	
	
	@JsonIgnore
	private int id;
	
	@NotNull(message = "Esse campo é obrigatório!")
	private LocalDate rentDate;
	
	@JsonIgnore
	private LocalDate returnDate;
	
	@JsonIgnore
	private LocalDate forecastDate;
	
	@NotNull(message = "Esse campo é obrigatório!")
	private BookModel book;

	@NotNull(message = "Esse campo é obrigatório!")
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
	

	
	
}
