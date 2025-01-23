package com.livraria.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.api.models.EditoraModel;

public interface EditoraRepository extends JpaRepository<EditoraModel, Integer>{

	
	Optional<EditoraModel> findByNome(String nome);
	
}
