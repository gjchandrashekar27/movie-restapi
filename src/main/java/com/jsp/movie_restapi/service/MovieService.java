package com.jsp.movie_restapi.service;

import java.util.List;

import com.jsp.movie_restapi.entity.Movie;

public interface MovieService {

	Movie createMovie(Movie movie);

	List<Movie> getAllMovies();

	Movie getMovieById(Long id);

	Movie updateMovie(Long id, Movie movieDetails);

	void deleteMovie(Long id);

	

}
