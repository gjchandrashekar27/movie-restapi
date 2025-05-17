package com.jsp.movie_restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data //Generates getters, setters, toString, equals, and hashCode.
@NoArgsConstructor // Generates no-arg constructor
@AllArgsConstructor // Generates all-args constructor

public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private String actor;
	
	private String actress;
	
	@Column(name = "image_link")
	private String imageLink;
	
	@Column(name = "trailer_link")
	private String trailerLink;
	
	private Double rating;
	
}
