package com.livraria.api.infra;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.livraria.api.exceptions.PublisherCannotBeDeletedException;
import com.livraria.api.exceptions.PublisherNameAlreadyExistsException;
import com.livraria.api.exceptions.PublisherNotFoundException;
import com.livraria.api.exceptions.UserEmailAlredyExistsException;
import com.livraria.api.exceptions.UserNotFoundException;
import com.livraria.api.exceptions.BookNameAlreadyExistsException;
import com.livraria.api.exceptions.BookNotFoundException;
import com.livraria.api.exceptions.DateInvalidFormatException;
import com.livraria.api.exceptions.DateIsAfterDateNowException;
import com.livraria.api.exceptions.RentDateAfterDateNowException;
import com.livraria.api.exceptions.RentNotFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<RestErrorMessage> UserNotFoundException(UserNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
        		new RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage())
        );
    }
	
	
	@ExceptionHandler(UserEmailAlredyExistsException.class)
	private ResponseEntity<RestErrorMessage> UserEmailAlredyExistsException(UserEmailAlredyExistsException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage())
		);
	}
	

	@ExceptionHandler(PublisherNameAlreadyExistsException.class)
	private ResponseEntity<RestErrorMessage> PublisherNameAlreadyExistsException(PublisherNameAlreadyExistsException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage())
		);
	}
	
	@ExceptionHandler(PublisherNotFoundException.class)
	private ResponseEntity<RestErrorMessage> PublisherNotFoundException(PublisherNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new  RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage())
		);
	}
	
	@ExceptionHandler(PublisherCannotBeDeletedException.class)
	private ResponseEntity<RestErrorMessage> PublisherCannotBeDeletedException(PublisherCannotBeDeletedException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage())
		);
	}

	
	@ExceptionHandler(BookNameAlreadyExistsException.class)
	private ResponseEntity<RestErrorMessage> BookNameAlreadyExistsException(BookNameAlreadyExistsException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage())
		);
	}
	
	@ExceptionHandler(BookNotFoundException.class)
	private ResponseEntity<RestErrorMessage> BookNotFoundException(BookNotFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
				new RestErrorMessage(HttpStatus.NOT_FOUND, e.getMessage())
		);
	}
	
	@ExceptionHandler(DateInvalidFormatException.class)
	private ResponseEntity<RestErrorMessage> DateInvalidFormatException(DateInvalidFormatException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage())
		);
	}
	
	@ExceptionHandler(DateIsAfterDateNowException.class)
	private ResponseEntity<RestErrorMessage> DateIsAfterDateNowException(DateIsAfterDateNowException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage())
		);
	}
	
	@ExceptionHandler(RentDateAfterDateNowException.class)
	private ResponseEntity<RestErrorMessage> RentDateAfterDateNowException(RentDateAfterDateNowException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage())
		);
	}
	
	@ExceptionHandler(RentNotFoundException.class)
	private ResponseEntity<RestErrorMessage> RentNotFoundException(RentNotFoundException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				new RestErrorMessage(HttpStatus.CONFLICT, e.getMessage())
				);
	}
	
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> HandleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
	
	
}
