package com.livraria.api.controller;

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

import com.livraria.api.dto.UserModelDto;
import com.livraria.api.models.UserModel;
import com.livraria.api.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livraria-api/user")
@Tag(name = "Usuário")
public class UserController {
	
	final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@Operation(summary = "EndPoint Teste")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Testar API.")
	})
	@GetMapping("hello")
	public ResponseEntity<Object> helloWorld(){
		return ResponseEntity.status(HttpStatus.OK).body("HELLO WORLD!!!!!!!!");
	}
	
	@Operation(summary = "Pegar todos os usuários")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário carregados com sucesso.")
	})
	@GetMapping
	public ResponseEntity<Object> getUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
	}
	
	@Operation(summary = "Salvar usuário")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário salvo com sucesso")
	})
	@PostMapping 
	public ResponseEntity<Object> saveUser(@RequestBody @Valid UserModelDto user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	@Operation(summary = "Editar usuário")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário editado com sucesso")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Object> editUser(@PathVariable(value = "id") int id, @RequestBody @Valid UserModelDto userDto){
		  return ResponseEntity.status(HttpStatus.OK).body(userService.edit(id, userDto));
	 
	}
	
	
	@Operation(summary = "Excluir usuário")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Usuário deletado com sucesso")
	})
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") int id){
		  userService.deleteUser(id);
		  return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado com sucesso!");
	}

}
