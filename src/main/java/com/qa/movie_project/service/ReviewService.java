package com.qa.movie_project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

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

	public List<ReviewDTO> getReviewsByMovieId(int id) {
		List<Review> reviews = reviewRepo.findByMovieId(id);
		List<ReviewDTO> dtos = new ArrayList<>();

		for (Review review : reviews) {
			dtos.add(this.toDTO(review));
		}
		return dtos;
	}

	public ReviewDTO getReview(int id) {
		Optional<Review> review = reviewRepo.findById(id);

		if (review.isPresent()) {
			return this.toDTO(review.get());
		}
		throw new EntityNotFoundException("Review not found with id " + id);
	}

}
