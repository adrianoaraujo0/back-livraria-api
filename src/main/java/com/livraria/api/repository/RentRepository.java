package com.livraria.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.livraria.api.models.RentModel;

public interface RentRepository extends JpaRepository<RentModel, Integer>{

}
