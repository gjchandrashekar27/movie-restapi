package com.jsp.movie_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.movie_restapi.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	boolean existsByName(String name);

}
