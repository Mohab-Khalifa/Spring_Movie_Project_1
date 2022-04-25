package com.qa.movie_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.movie_project.dto.ReviewDTO;
import com.qa.movie_project.service.ReviewService;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {

	private ReviewService reviewService;

	@Autowired
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}

	@GetMapping
	public ResponseEntity<List<ReviewDTO>> getReviews() {
		return ResponseEntity.ok(reviewService.getReviews());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<ReviewDTO> getReview(@PathVariable(name = "id") int id) {
		return ResponseEntity.ok(reviewService.getReview(id));
	}
}
