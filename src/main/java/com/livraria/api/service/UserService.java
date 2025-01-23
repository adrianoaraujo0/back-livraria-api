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
	
	public UserModel save(UserModel user) {
	    Optional<UserModel> userOptional = userRepository.findByEmail(user.getEmail());
	    
	    if(userOptional.isPresent()){
	    	throw new UserEmailAlredyExistsException();
	    }
	    
		return userRepository.save(user);
	}
	
	
	public UserModel edit(int id, UserModelDto userDto) {
	  UserModel userFinded = findUserById(id).get();
	  Optional<UserModel> userOptional = userRepository.findByEmail(userDto.getEmail());
	  
	  UserModel userModel = new UserModel();
	  userModel.setId(userFinded.getId());
	  BeanUtils.copyProperties(userDto, userModel);
	  
	  if(userFinded.getEmail() != userDto.getEmail() && userOptional.isPresent()) {
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
