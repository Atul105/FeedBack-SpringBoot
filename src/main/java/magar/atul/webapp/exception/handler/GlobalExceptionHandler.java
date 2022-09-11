package magar.atul.webapp.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import magar.atul.webapp.exception.FeedBackNotFound;
import magar.atul.webapp.exception.InvalidFeedBackException;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;
	
	//Feedback not found
	@ExceptionHandler(value = FeedBackNotFound.class)
	public ResponseEntity<ExceptionResponse> notFoundException(FeedBackNotFound ex) {
		response = new ExceptionResponse(ex.getMessage(), HttpStatus.NOT_FOUND.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=InvalidFeedBackException.class)
	public ResponseEntity<ExceptionResponse> invalidException(InvalidFeedBackException ex){
		response = new ExceptionResponse(ex.getMessage(),
				HttpStatus.BAD_REQUEST.name(), ex.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

		
}
