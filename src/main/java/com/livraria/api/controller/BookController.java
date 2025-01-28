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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/livraria-api/book", produces="application/json")
@Tag(name = "Livro")
public class BookController {
	
	BookService bookService;
	EditoraService editoraService;
	
	public BookController(BookService bookService, EditoraService editoraService){
		this.bookService = bookService;
		this.editoraService = editoraService;
	}
	
	
	@Operation(summary = "Pegar todos os livros")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Livros carregados com sucesso.")
	})
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBooks(){
		return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
	}
	
	
	@Operation(summary = "Salvar livro")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Livro salvo com sucesso.")
	})
	@PostMapping
	public ResponseEntity<Object> saveBook(@RequestBody @Valid BookDto bookDto){	
			return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookDto));
	}
	
	
	@Operation(summary = "Editar livro")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Livro editado com sucesso.")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> editBook(@PathVariable(value = "id") int id, @RequestBody @Valid BookDto bookDto) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(bookService.edit(id, bookDto));
	}
	
	
	@Operation(summary = "Excluir livro")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Livro excluído com sucesso.")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteBook(@PathVariable(value = "id") int id){
		bookService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Livro deletado com sucesso!");
	}
}
