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

import com.livraria.api.dto.EditoraDto;
import com.livraria.api.models.EditoraModel;
import com.livraria.api.service.EditoraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livraria-api/publisher")
@Tag(name = "Editora")
public class EditoraController {

	EditoraService editoraService;
	
	public EditoraController(EditoraService editoraService){
		this.editoraService = editoraService;
	}
	
	@Operation(summary = "Pegar todas as editoras")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados carregados com sucesso.")
	})
	@GetMapping
	public ResponseEntity<List<EditoraModel>> getAllEditoras(){
		return ResponseEntity.status(HttpStatus.OK).body(editoraService.getAllEditoras());
	}
	
	@Operation(summary = "Salvar editora")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Editora salva com sucesso.")
	})
	@PostMapping
	public ResponseEntity<Object> saveEditora(@RequestBody @Valid EditoraDto editoraDto){
		return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.saveEditora(editoraDto));
	}
	
	
	@Operation(summary = "Editar editora")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Editora editada com sucesso.")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> editEditora(@PathVariable(value = "id") int id, @RequestBody @Valid EditoraDto editoraDto){	
		return ResponseEntity.status(HttpStatus.OK).body(editoraService.editEditora(id, editoraDto));
	}
	
	@Operation(summary = "Excluir editora")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Editora excluída com sucesso.")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEditora(@PathVariable(value = "id") int id){
		editoraService.deleteEditora(id);
		return ResponseEntity.status(HttpStatus.OK).body("Editora deletada com sucesso");
	}
	
}
