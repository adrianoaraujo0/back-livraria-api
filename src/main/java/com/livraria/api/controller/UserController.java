package com.livraria.api.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livraria-api/user")
public class UserController {
	
	
	final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	@PostMapping 
	public ResponseEntity<Object> saveUser(@RequestBody @Valid UserModel user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	@GetMapping
	public ResponseEntity<Object> getUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editUser(@PathVariable(value = "id") int id, @RequestBody @Valid UserModelDto userDto){
	 Optional<UserModel> userOptional =	userService.findUserById(id);
	  if(userOptional.isEmpty()) {
		  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	  }
	  
	  
	  UserModel userModel = new UserModel();
	  userModel.setId(userOptional.get().getId());
	  BeanUtils.copyProperties(userDto, userModel);
	  
	  return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") int id){
		Optional<UserModel> userOptional =	userService.findUserById(id);
		  if(userOptional.isEmpty()) {
			  return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		  }
		  userService.deleteUser(id);
		  return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
	}
	
	
	

}
