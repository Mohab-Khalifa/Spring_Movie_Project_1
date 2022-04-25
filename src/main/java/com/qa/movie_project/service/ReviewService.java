package com.qa.movie_project.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.qa.movie_project.dto.ReviewDTO;
import com.qa.movie_project.entity.Review;
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

	private ReviewDTO toDTO(Review review) {
		return modelMapper.map(review, ReviewDTO.class);
	}

	public List<ReviewDTO> getReviews() {
		List<Review> reviews = reviewRepo.findAll();
		List<ReviewDTO> dtos = new ArrayList<>();

		for (Review review : reviews) {
			dtos.add(this.toDTO(review));
		}
		return dtos;
	}
}
