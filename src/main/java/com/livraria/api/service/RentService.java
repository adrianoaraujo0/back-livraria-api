package com.livraria.api.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.api.dto.RentDto;
import com.livraria.api.exceptions.RentDateAfterDateNowException;
import com.livraria.api.exceptions.RentNotFoundException;
import com.livraria.api.models.BookModel;
import com.livraria.api.models.RentModel;
import com.livraria.api.repository.RentRepository;

@Service
public class RentService {
	
	@Autowired
	RentRepository rentRepository;
	
	@Autowired
	UserService userService;

	@Autowired
	EditoraService editoraService;

	@Autowired
	BookService bookService;
	
	
	
	public RentModel save(RentDto rentDto) throws Exception {
		verifyIfRentDateIsAfterDateNow(rentDto);
		userService.findUserById(rentDto.getUser().getId());
		bookService.verifyIfBookExists(rentDto.getBook().getId());
		editoraService.findEditoryById(rentDto.getBook().getPublisher().getId());
		
		BookModel book =  bookService.decrementBook(rentDto.getBook().getId());
		
		rentDto.setBook(book);
		rentDto.setForecastDate(rentDto.getRentDate().plusDays(14));
		RentModel rent = new RentModel();
		BeanUtils.copyProperties(rentDto, rent);
		
		rent = rentRepository.save(rent);
		rentDto.setId(rent.getId());
		return rent;
	}
	
	void verifyIfRentDateIsAfterDateNow(RentDto rentDto) {
		if(rentDto.getRentDate().isAfter(LocalDate.now())) {
			
			throw new RentDateAfterDateNowException();
		}
	}
	
	public RentModel edit(int id, RentDto rentDto) throws Exception{
		rentExists(id);
		rentDto.setId(id);
		return save(rentDto);
	}
	
	public List<RentModel> getAll(){
	 return	rentRepository.findAll();
	}
	
	public void delete(int id) {
		rentExists(id);
		rentRepository.deleteById(id);
	}
	
	
	public void rentExists(int id) {
		Optional<RentModel> rentOptional= rentRepository.findById(id);
		if(!rentOptional.isPresent()) throw new RentNotFoundException();
	}
	


}
