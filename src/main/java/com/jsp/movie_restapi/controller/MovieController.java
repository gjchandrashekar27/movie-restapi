package com.jsp.movie_restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.movie_restapi.entity.Movie;
import com.jsp.movie_restapi.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	 @PostMapping
	    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
	        Movie savedMovie = movieService.createMovie(movie);
	        // Return 201 Created with the saved movie in the body
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
	    }
	 
	 @GetMapping
	 public ResponseEntity<List<Movie>> getAllMovies() {
	     List<Movie> movies = movieService.getAllMovies();
	     return new ResponseEntity<>(movies, HttpStatus.OK);
	 }
	 
	 @GetMapping("/{id}")
	    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
	        Movie movie = movieService.getMovieById(id);
	        return new ResponseEntity<>(movie, HttpStatus.OK);
	    }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
	     Movie updatedMovie = movieService.updateMovie(id, movieDetails);
	     return ResponseEntity.ok(updatedMovie);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
	     movieService.deleteMovie(id);
	     return ResponseEntity.ok("Movie with ID " + id + " deleted successfully");
	 }

}
