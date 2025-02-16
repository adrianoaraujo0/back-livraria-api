package com.livraria.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.api.dto.BookDto;
import com.livraria.api.exceptions.BookNameAlreadyExistsException;
import com.livraria.api.exceptions.BookNotFoundException;
import com.livraria.api.exceptions.BookOutOfStockException;
import com.livraria.api.exceptions.DateInvalidFormatException;
import com.livraria.api.exceptions.DateIsAfterDateNowException;
import com.livraria.api.exceptions.PublisherNotFoundException;
import com.livraria.api.models.BookModel;
import com.livraria.api.repository.BookRepository;
import com.livraria.api.repository.EditoraRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	EditoraRepository editoraRepository;
	
	public List<BookModel> getAllBooks(){
		List<BookModel> books = bookRepository.findAll();
		List<BookDto> booksDto = new ArrayList<>();;
		
		books.forEach(book -> {
			BookDto bookDto = new BookDto();
			BeanUtils.copyProperties(book, bookDto);
			booksDto.add(bookDto);
		});
		
		return books;
	}
	
	public BookModel save(BookDto bookDto) {
		 verifyIfBookIsRepeat(bookDto);
		 verifyIfPublisherExists(bookDto);
		 verifyIfReleaseIsAfterDateNow(bookDto);
		 
		 BookModel book = new BookModel();
		 BeanUtils.copyProperties(bookDto, book);
		 
		 
		 BookModel bookSaved = bookRepository.save(book);
		 
		return bookSaved;
	} 
	
	
	
	public BookModel edit(int id, BookDto bookDto) throws Exception  {
		verifyIfPublisherExists(bookDto);
		verifyIfTheBookNameIsUsedInAnotherBook(id, bookDto);
		validateDateTime(bookDto.getRelease().toString());
		verifyIfReleaseIsAfterDateNow(bookDto);
		BookModel book = new BookModel();
		BeanUtils.copyProperties(bookDto, book);
		book.setId(id);
	BookModel bookSaved =bookRepository.save(book);
		 
		return bookSaved;
	}
	
	
	void validateDateTime(String dateTime) throws Exception {
		try {
			LocalDate.parse(dateTime);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			throw new DateInvalidFormatException();
		}
	}
	
	public void delete(int id) {
		verifyIfBookExists(id);
		
		bookRepository.deleteById(id);
	}
	
	public void verifyIfBookExists(int id) {
		Optional<BookModel> bookOptional = bookRepository.findById(id);
		
		if(!bookOptional.isPresent()) {
			throw new BookNotFoundException();
		}
	}
	
	
	
	public void verifyIfBookIsRepeat(BookDto bookDto) {
		Optional<BookModel> bookOptional = bookRepository.findBookByName(bookDto.getName());
		if(bookOptional.isPresent()) {
			throw new BookNameAlreadyExistsException();
		}
	}
	
	public void verifyIfPublisherExists(BookDto bookDto) {
		 int editoraId = bookDto.getPublisher().getId();
		 if(editoraRepository.findById(editoraId).isEmpty()){
		 	throw new PublisherNotFoundException();
		 }
	}
	
	public void verifyIfReleaseIsAfterDateNow(BookDto bookDto) {
		if(bookDto.getRelease().isAfter(LocalDate.now())) {
			throw new DateIsAfterDateNowException();
		}
	}
	

	public void verifyIfTheBookNameIsUsedInAnotherBook(int id, BookDto bookDto) {
		Optional<BookModel> bookAdded = bookRepository.findBookByName(bookDto.getName());
		boolean bookAlreadyExists = bookAdded.isPresent() && id != bookAdded.get().getId();
		if(bookAlreadyExists) {
			throw new BookNameAlreadyExistsException();
		}
	}
	
	public BookModel decrementBook(int id) throws Exception {
		Optional<BookModel> bookOptional = bookRepository.findById(id);
		int quantity = bookOptional.get().getQuantity();
		int totalRented = bookOptional.get().getTotalRented();
		
		if(quantity == 0) throw new BookOutOfStockException();
	
		bookOptional.get().setQuantity(quantity - 1);
		bookOptional.get().setTotalRented(totalRented + 1);
		
		BookDto bookDto = new BookDto();
		BeanUtils.copyProperties(bookOptional.get(), bookDto);
		edit(id, bookDto);
		
		return bookOptional.get();
	}
	
	

	

}
