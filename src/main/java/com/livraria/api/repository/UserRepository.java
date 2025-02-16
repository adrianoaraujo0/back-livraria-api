package com.livraria.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.api.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{
	
	Optional<UserModel> findByEmail(String email);

}
