package com.qa.movie_project.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.movie_project.repo.MovieRepo;

@Service
public class MovieService {

	private MovieRepo movieRepo;
	private ReviewService reviewService;
	private ModelMapper modelMapper;

}
