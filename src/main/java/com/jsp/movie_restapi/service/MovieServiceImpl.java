package com.jsp.movie_restapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.movie_restapi.entity.Movie;
import com.jsp.movie_restapi.exception.MovieAlreadyExistsException;
import com.jsp.movie_restapi.exception.MovieNotFoundException;
import com.jsp.movie_restapi.exception.NoMoviesFoundException;
import com.jsp.movie_restapi.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	MovieRepository movieRepository;

	@Override
	public Movie createMovie(Movie movie) {
		if(movieRepository.existsByName(movie.getName())) {
			throw new MovieAlreadyExistsException("Movie Name Already Exists: " + movie.getName());
		}
		
		return movieRepository.save(movie);
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = movieRepository.findAll();
	    if (movies.isEmpty()) {
	        throw new NoMoviesFoundException("No movies are available.");
	    }
	    return movies;
	}

	@Override
	public Movie getMovieById(Long id) {
		 return movieRepository.findById(id)
		            .orElseThrow(() -> new MovieNotFoundException("Movie with ID " + id + " not found."));
	}

	@Override
	public Movie updateMovie(Long id, Movie movieDetails) {
		 Movie existingMovie = movieRepository.findById(id)
			        .orElseThrow(() -> new MovieNotFoundException("Movie with ID " + id + " not found."));
			    
			    existingMovie.setName(movieDetails.getName());
			    existingMovie.setDescription(movieDetails.getDescription());
			    existingMovie.setActor(movieDetails.getActor());
			    existingMovie.setActress(movieDetails.getActress());
			    existingMovie.setImageLink(movieDetails.getImageLink());
			    existingMovie.setTrailerLink(movieDetails.getTrailerLink());
			    existingMovie.setRating(movieDetails.getRating());

			    return movieRepository.save(existingMovie);
	}

	@Override
	public void deleteMovie(Long id) {
		 Movie movie = movieRepository.findById(id)
			        .orElseThrow(() -> new MovieNotFoundException("Movie with ID " + id + " not found."));
			    movieRepository.delete(movie);
		
	}



}
