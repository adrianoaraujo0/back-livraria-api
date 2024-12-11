package com.livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.api.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Integer>{

}
