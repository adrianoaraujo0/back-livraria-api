package com.livraria.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.api.dto.RentDto;
import com.livraria.api.exceptions.RentDateAfterDateNowException;
import com.livraria.api.models.RentModel;
import com.livraria.api.repository.RentRepository;

@Service
public class RentService {
	
	@Autowired
	RentRepository rentRepository;
	
	public RentDto save(RentDto rentDto) {
//		verifyIfRentDateIsAfterDateNow(rentDto);
		
		
		RentModel rent = new RentModel();
		BeanUtils.copyProperties(rentDto, rent);
		
		rent = rentRepository.save(rent);
		rentDto.setId(rent.getId());
		return rentDto;
	}
	
	void verifyIfRentDateIsAfterDateNow(RentDto rentDto) {
		if(rentDto.getRentDate().isBefore(LocalDate.now())) {
			throw new RentDateAfterDateNowException();
		}
	}
	
	public List<RentModel> getAll(){
	 return	rentRepository.findAll();
	}
	


}
