package com.livraria.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.api.dto.UserModelDto;
import com.livraria.api.exceptions.UserEmailAlredyExistsException;
import com.livraria.api.exceptions.UserNotFoundException;
import com.livraria.api.models.UserModel;
import com.livraria.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public UserModel save(UserModelDto user) {
	    Optional<UserModel> userOptional = userRepository.findByEmail(user.getEmail());
	    
	    if(userOptional.isPresent()){
	    	throw new UserEmailAlredyExistsException();
	    }
	    
	    UserModel userModel = new UserModel();
	    
	    BeanUtils.copyProperties(user, userModel);
	    
		return userRepository.save(userModel);
	}
	
	
	public UserModel edit(int id, UserModelDto userDto) {
	  UserModel userFinded = findUserById(id).get();
	  Optional<UserModel> userOptional = userRepository.findByEmail(userDto.getEmail());
	  boolean emailExists = userOptional.isPresent();
	  
	  UserModel userModel = new UserModel();
	  userModel.setId(userFinded.getId());
	  BeanUtils.copyProperties(userDto, userModel);
	  
	  System.out.println(userFinded.getEmail());
	  System.out.println(userDto.getEmail());
	  
	  if(!userDto.getEmail().equals(userFinded.getEmail()) && emailExists) {
		  throw new UserEmailAlredyExistsException();
	  }
	  
	  return userRepository.save(userModel);
	}
	
	public List<UserModel> getUsers(){
		return userRepository.findAll();
	}
	
	public Optional<UserModel> findUserById(int id) {
		Optional<UserModel> userOptional = userRepository.findById(id);
		
		 if(userOptional.isEmpty()) {
			throw new UserNotFoundException();
		 }
		  
		return userOptional;
	}
	
	public void deleteUser(int id) {
		UserModel userFinded = findUserById(id).get();
		userRepository.deleteById(userFinded.getId());
	}
	
	
}
