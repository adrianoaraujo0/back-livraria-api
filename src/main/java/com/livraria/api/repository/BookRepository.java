package com.livraria.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.api.models.BookModel;

public interface BookRepository extends JpaRepository<BookModel, Integer>{
	
	
	List<BookModel> findByPublisherId(int publisherId);
	
	Optional<BookModel> findBookByName(String nome);
	

}
