package com.livraria.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livraria.api.models.UserModel;
import com.livraria.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Transactional
	public UserModel save(UserModel user) {
		return userRepository.save(user);
	}
	
	public List<UserModel> getUsers(){
		return userRepository.findAll();
	}
	
	public Optional<UserModel> findUserById(int id) {
		return userRepository.findById(id);
	}
	
	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}
	
	
}
