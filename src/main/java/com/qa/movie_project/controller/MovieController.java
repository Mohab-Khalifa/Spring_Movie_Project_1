package com.qa.movie_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.movie_project.dto.MovieDTO;
import com.qa.movie_project.service.MovieService;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {

	private MovieService movieService;

	@Autowired
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}

	// Read - gets the whole list of movies
	@GetMapping
	public ResponseEntity<List<MovieDTO>> getMovies() {
		List<MovieDTO> responseBody = this.movieService.getMovies();
		return new ResponseEntity<List<MovieDTO>>(responseBody, HttpStatus.OK);
	}

}
