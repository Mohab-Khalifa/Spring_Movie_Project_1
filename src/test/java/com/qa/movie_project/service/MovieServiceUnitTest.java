package com.qa.movie_project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.qa.movie_project.dto.MovieDTO;
import com.qa.movie_project.entity.Movie;
import com.qa.movie_project.repo.MovieRepo;

@ExtendWith(MockitoExtension.class)
public class MovieServiceUnitTest {

	@Mock
	private MovieRepo movieRepo;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private MovieService movieService;

	private List<Movie> movies;
	private List<MovieDTO> movieDTOs;

	@BeforeEach
	public void init() {
		movies = List.of(new Movie(1, "Interstellar", "Thriller", 2014, 169),
				new Movie(1, "Toy Story", "Animation", 1995, 81));
		movieDTOs = List.of(new MovieDTO(1, "Interstellar", "Thriller", 2014, 169),
				new MovieDTO(2, "Toy Story", "Animation", 1995, 81));
	}

	@Test
	public void getAllTest() {
		// Arrange
		when(movieRepo.findAll()).thenReturn(movies);
		when(modelMapper.map(movies.get(0), MovieDTO.class)).thenReturn(movieDTOs.get(0));
		when(modelMapper.map(movies.get(1), MovieDTO.class)).thenReturn(movieDTOs.get(1));

		// Act
		List<MovieDTO> actual = movieService.getMovies();

		// Assert
		assertEquals(movieDTOs, actual);
		verify(movieRepo).findAll();
		verify(modelMapper).map(movies.get(0), MovieDTO.class);
		verify(modelMapper).map(movies.get(1), MovieDTO.class);
	}

	@Test
	public void getByIdTest() {
		// Arrange
		Movie movie = movies.get(0);
		MovieDTO movieDTO = movieDTOs.get(0);
		int id = movie.getId();

		when(movieRepo.findById(id)).thenReturn(Optional.of(movie));
		when(modelMapper.map(movie, MovieDTO.class)).thenReturn(movieDTO);

		// Act
		MovieDTO actual = movieService.getMovie(id);

		// Assert
		assertEquals(movieDTO, actual);
		verify(movieRepo).findById(id);
		verify(modelMapper).map(movie, MovieDTO.class);
	}

	@Test
	public void getByInvalidIdTest() {
		// Arrange
		int id = 67;
		when(movieRepo.findById(id)).thenReturn(Optional.empty());

		// Act
		EntityNotFoundException exception = Assertions.assertThrows(EntityNotFoundException.class, () -> {
			movieService.getMovie(id);
		});

		// Assert
		String expectedMessage = "Movie not found with id " + id;
		assertEquals(expectedMessage, exception.getMessage());
		verify(movieRepo).findById(id);
	}

}
