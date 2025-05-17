package com.jsp.movie_restapi.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	 @ExceptionHandler(MovieAlreadyExistsException.class)
	    public ResponseEntity<String> handleMovieAlreadyExistsException(MovieAlreadyExistsException ex) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
	    }
	 
	 @ExceptionHandler(NoMoviesFoundException.class)
	    public ResponseEntity<String> handleNoMoviesFound(NoMoviesFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(MovieNotFoundException.class)
	    public ResponseEntity<Object> handleMovieNotFound(MovieNotFoundException ex) {
	        Map<String, Object> response = new HashMap<>();
	        response.put("timestamp", LocalDateTime.now());
	        response.put("message", ex.getMessage());
	        response.put("status", HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    }


}
