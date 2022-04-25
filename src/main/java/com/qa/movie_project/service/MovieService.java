package com.qa.movie_project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.movie_project.dto.MovieDTO;
import com.qa.movie_project.entity.Movie;
import com.qa.movie_project.repo.MovieRepo;

@Service
public class MovieService {

	private MovieRepo movieRepo;
	private ReviewService reviewService;
	private ModelMapper modelMapper;

	@Autowired
	public MovieService(MovieRepo movieRepo, ReviewService reviewService, ModelMapper modelMapper) {
		super();
		this.movieRepo = movieRepo;
		this.reviewService = reviewService;
		this.modelMapper = modelMapper;
	}

	private MovieDTO toDTO(Movie movie) {
		return modelMapper.map(movie, MovieDTO.class);
	}
}
