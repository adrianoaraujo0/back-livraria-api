package com.livraria.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livraria.api.dto.RentDto;
import com.livraria.api.models.RentModel;
import com.livraria.api.service.RentService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/livraria-api/rent")
public class RentController {
	
	RentService rentService;
	
	public RentController(RentService rentService) {
		this.rentService = rentService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<RentModel>> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(rentService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<RentDto> save(@RequestBody RentDto rentDto){
		System.out.println("TESTE");
		return ResponseEntity.status(HttpStatus.CREATED).body(rentService.save(rentDto));
	}
	

}
	