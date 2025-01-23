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

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livraria-api/editora")
public class EditoraController {

	EditoraService editoraService;
	
	public EditoraController(EditoraService editoraService){
		this.editoraService = editoraService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<EditoraModel>> getAllEditoras(){
		return ResponseEntity.status(HttpStatus.OK).body(editoraService.getAllEditoras());
	}
	
	@PostMapping
	public ResponseEntity<Object> saveEditora(@RequestBody @Valid EditoraModel editora){
		return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.saveEditora(editora));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editEditora(@PathVariable(value = "id") int id, @RequestBody @Valid EditoraDto editoraDto){	
		return ResponseEntity.status(HttpStatus.OK).body(editoraService.editEditora(id, editoraDto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEditora(@PathVariable(value = "id") int id){
		editoraService.deleteEditora(id);
		return ResponseEntity.status(HttpStatus.OK).body("Editora deletada com sucesso");
	}
	
}
