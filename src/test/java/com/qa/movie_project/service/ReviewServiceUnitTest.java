package com.qa.movie_project.service;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.qa.movie_project.dto.MovieDTO;
import com.qa.movie_project.dto.ReviewDTO;
import com.qa.movie_project.entity.Movie;
import com.qa.movie_project.entity.Review;
import com.qa.movie_project.repo.ReviewRepo;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceUnitTest {

	@Mock
	private ReviewRepo reviewRepo;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private ReviewService reviewService;

	private List<Movie> movies;
	private List<MovieDTO> movieDTOs;
	private List<Review> reviews;
	private List<ReviewDTO> reviewDTOs;

	@BeforeEach
	public void init() {
		movies = List.of(new Movie(1, "Interstellar", "Thriller", 2014, 169),
				new Movie(1, "Toy Story", "Animation", 1995, 81));
		movieDTOs = List.of(new MovieDTO(1, "Interstellar", "Thriller", 2014, 169),
				new MovieDTO(2, "Toy Story", "Animation", 1995, 81));

		reviews = List.of(new Review(1, 9, "Test comment 1", movies.get(0)),
				new Review(1, 5, "Test comment 2", movies.get(0)));
		reviewDTOs = List.of(new ReviewDTO(1, 9, "Test comment 1", movieDTOs.get(0), reviews.get(0).getPostedAt()),
				new ReviewDTO(2, 5, "Test comment 2", movieDTOs.get(1), reviews.get(1).getPostedAt()));
	}

}
