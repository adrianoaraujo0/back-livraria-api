package com.livraria.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.api.dto.BookDto;
import com.livraria.api.service.BookService;
import com.livraria.api.service.EditoraService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livraria-api/book")
public class BookController {
	
	BookService bookService;
	EditoraService editoraService;
	
	public BookController(BookService bookService, EditoraService editoraService){
		this.bookService = bookService;
		this.editoraService = editoraService;
	}
	
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBooks(){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveBook(@RequestBody @Valid BookDto bookDto){	
			return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookDto));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editBook(@PathVariable(value = "id") int id, @RequestBody @Valid BookDto bookDto) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(bookService.edit(id, bookDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") int id){
		bookService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso!");
	}
}
