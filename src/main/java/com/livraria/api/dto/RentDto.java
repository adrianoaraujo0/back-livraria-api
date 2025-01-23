package com.livraria.api.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.livraria.api.models.BookModel;
import com.livraria.api.models.UserModel;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RentDto {
	
	private int id;
	
	@NotNull(message = "Esse campo é obrigatório!")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate rentDate;
	
	@JsonIgnore
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate returnDate;
	
	@JsonIgnore
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate forecastDate;
	
	@NotNull(message = "Esse campo é obrigatório!")
	private BookModel book;
//	
	@NotNull(message = "Esse campo é obrigatório!")
	private UserModel user;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getRentDate() {
		System.out.println("GET 1");
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		System.out.println("GET 2");
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
		System.out.println("GET 3");
		return book;
	}

	public void setBook(BookModel book) {
		System.out.println("GET 4");
		this.book = book;
	}

	public UserModel getUser() {
		System.out.println("GET 5");
		return user;
	}

	public void setUser(UserModel user) {
		System.out.println("6");
		this.user = user;
	}
	

	
	
}
