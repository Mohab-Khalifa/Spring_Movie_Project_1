package com.qa.movie_project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

	@Test
	public void getAllTest() {
		// Arrange-Act-Assert
		// Arrange: setup the data and components under test
		when(reviewRepo.findAll()).thenReturn(reviews);
		when(modelMapper.map(reviews.get(0), ReviewDTO.class)).thenReturn(reviewDTOs.get(0));
		when(modelMapper.map(reviews.get(1), ReviewDTO.class)).thenReturn(reviewDTOs.get(1));

		// Act: performing the action under test
		List<ReviewDTO> actual = reviewService.getReviews();

		// Assert: validate the action was successful
		assertEquals(reviewDTOs, actual);
		verify(reviewRepo).findAll();
		verify(modelMapper).map(reviews.get(0), ReviewDTO.class);
		verify(modelMapper).map(reviews.get(1), ReviewDTO.class);
	}

	@Test
	public void getByIdTest() {
		// Arrange
		Review review = reviews.get(0);
		ReviewDTO reviewDTO = reviewDTOs.get(0);
		int id = review.getId();

		when(reviewRepo.findById(id)).thenReturn(Optional.of(review));
		when(modelMapper.map(review, ReviewDTO.class)).thenReturn(reviewDTO);

		// Act
		ReviewDTO actual = reviewService.getReview(id);

		// Assert
		assertEquals(reviewDTO, actual);
		verify(reviewRepo).findById(id);
		verify(modelMapper).map(review, ReviewDTO.class);
	}

}
