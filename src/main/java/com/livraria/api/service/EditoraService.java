package com.livraria.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livraria.api.dto.EditoraDto;
import com.livraria.api.exceptions.PublisherCannotBeDeletedException;
import com.livraria.api.exceptions.PublisherNameAlreadyExistsException;
import com.livraria.api.exceptions.PublisherNotFoundException;
import com.livraria.api.models.BookModel;
import com.livraria.api.models.EditoraModel;
import com.livraria.api.repository.BookRepository;
import com.livraria.api.repository.EditoraRepository;


@Service
public class EditoraService {
	
	@Autowired
	EditoraRepository editoraRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	public Optional<EditoraModel> findEditoryById(int id) {
		Optional<EditoraModel> editoraModelOptional = editoraRepository.findById(id);
		if(editoraModelOptional.isEmpty()) {
			throw new PublisherNotFoundException();
		}
		
		return editoraModelOptional;
		
	}
	
	public boolean editoraExists(int id) {
		return findEditoryById(id).isPresent();
	}
	
	public EditoraModel saveEditora(EditoraModel editora) {
		Optional<EditoraModel> editoraOptional = editoraRepository.findByNome(editora.getNome());
		
		if(editoraOptional.isPresent()) {
			throw new PublisherNameAlreadyExistsException();
		}
		
		return editoraRepository.save(editora);
	}
	
	public EditoraModel editEditora(int id, EditoraDto editoraDto) {
		Optional<EditoraModel> editoraOptional = findEditoryById(id);
		
		verifyPublisherIfNameAlreadyExists(id, editoraDto);
		
		EditoraModel editoraModel = new EditoraModel();
		editoraModel.setId(editoraOptional.get().getId());
		BeanUtils.copyProperties(editoraDto, editoraModel);
		
		
		return editoraRepository.save(editoraModel);
	}
	
	public void verifyPublisherIfNameAlreadyExists(int id, EditoraDto editora) {
		Optional<EditoraModel> editoraOptional = editoraRepository.findByNome(editora.getNome());
		if(editoraOptional.isPresent() && editoraOptional.get().getId() != id) {
			throw new PublisherNameAlreadyExistsException();
		}
	}
	
	public List<EditoraModel> getAllEditoras(){
		return editoraRepository.findAll();
	}
	

	public void deleteEditora(int id) {
		findEditoryById(id);
		verifyPublisherIsUsed(id);
		
		 editoraRepository.deleteById(id);
	}	
	
	public void verifyPublisherIsUsed(int id) {
		 List<BookModel> books = bookRepository.findByPublisherId(id);
		
		 if(!books.isEmpty()) {
			 throw new PublisherCannotBeDeletedException();
		 }
		 
		
		
	}
	

}
