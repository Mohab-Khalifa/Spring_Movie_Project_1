package com.qa.movie_project.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.movie_project.repo.ReviewRepo;

@Service
public class ReviewService {

	private ReviewRepo reviewRepo;
	private ModelMapper modelMapper;

	public ReviewService(ReviewRepo reviewRepo, ModelMapper modelMapper) {
		super();
		this.reviewRepo = reviewRepo;
		this.modelMapper = modelMapper;
	}

}
