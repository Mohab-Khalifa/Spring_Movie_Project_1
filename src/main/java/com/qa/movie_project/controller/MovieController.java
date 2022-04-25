package com.qa.movie_project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.movie_project.dto.MovieDTO;
import com.qa.movie_project.dto.NewMovieDTO;
import com.qa.movie_project.dto.ReviewDTO;
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

	// Read - gets a movie by it's id
	@GetMapping(path = "/{id}")
	public ResponseEntity<MovieDTO> getMovie(@PathVariable(name = "id") int id) {
		MovieDTO movie = movieService.getMovie(id);
		return new ResponseEntity<>(movie, HttpStatus.OK);
	}

	// Read - gets the reviews of a specific movie by it's Id
	@GetMapping(path = "/{id}/reviews")
	public ResponseEntity<List<ReviewDTO>> getMovieReviews(@PathVariable(name = "id") int movieId) {
		return ResponseEntity.ok(movieService.getMovieReviews(movieId));
	}

	// Create - create a movie to add
	@PostMapping
	public ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody NewMovieDTO movie) {
		MovieDTO newMovie = movieService.createMovie(movie);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "http://localhost:8080/movie/" + newMovie.getId());

		return new ResponseEntity<>(newMovie, headers, HttpStatus.CREATED);
	}

	// Update - update a movie by it's Id
	@PutMapping(path = "/{id}")
	public ResponseEntity<MovieDTO> updateMovie(@RequestBody NewMovieDTO newMovieDTO,
			@PathVariable(name = "id") int id) {
		MovieDTO movieChange = this.movieService.updateMovie(newMovieDTO, id);
		return new ResponseEntity<MovieDTO>(movieChange, HttpStatus.ACCEPTED);
	}

}
