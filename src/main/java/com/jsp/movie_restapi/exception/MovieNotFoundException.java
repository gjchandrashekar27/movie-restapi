package com.jsp.movie_restapi.exception;

public class MovieNotFoundException  extends RuntimeException{
	
	 public MovieNotFoundException(String message) {
	        super(message);
	    }

}
