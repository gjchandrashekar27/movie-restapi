package com.jsp.movie_restapi.exception;

public class MovieAlreadyExistsException extends RuntimeException {
	
	 public MovieAlreadyExistsException(String message) {
	        super(message);
	    }

}
