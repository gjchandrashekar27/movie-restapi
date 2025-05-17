package com.jsp.movie_restapi.exception;

public class NoMoviesFoundException extends RuntimeException {
	
	 public NoMoviesFoundException(String message) {
	        super(message);
	    }

}
