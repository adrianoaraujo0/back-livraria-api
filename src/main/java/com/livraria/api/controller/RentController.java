package com.livraria.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.livraria.api.dto.RentDto;
import com.livraria.api.models.RentModel;
import com.livraria.api.service.RentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/livraria-api/rent", produces = "application/json")
@Tag(name = "Aluguel")
public class RentController {
	
	RentService rentService;
	
	public RentController(RentService rentService) {
		this.rentService = rentService;
	}
	
	
	@Operation(summary = "Pegar todos os alugueis", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Dados carregados com sucesso.")
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RentModel>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(rentService.getAll());
	}
	
	
	@Operation(summary = "Salvar aluguel", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Aluguel salvo com sucesso.")
	})
	@PostMapping
	public ResponseEntity<RentModel> save(@RequestBody RentDto rentDto) throws Exception{
		return ResponseEntity.status(HttpStatus.CREATED).body(rentService.save(rentDto));
	}
	
	@Operation(summary = "Excluir aluguel.", method = "DELETE")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Aluguel excluído com sucesso.")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") int id){
		rentService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Aluguel deletado com sucesso!");
	}
	
	@Operation(summary = "Editar aluguel.", method = "PUT")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Aluguel editado com sucesso.")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> edit(@PathVariable(value = "id") int id, @RequestBody @Valid RentDto rentDto) throws Exception{
		return ResponseEntity.status(HttpStatus.OK).body(rentService.edit(id, rentDto));
	}
	
	
	

}
	