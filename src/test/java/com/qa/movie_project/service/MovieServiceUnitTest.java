package com.qa.movie_project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

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

		when(movieRepo.findAll()).thenReturn(movies);
		when(modelMapper.map(movies.get(0), MovieDTO.class)).thenReturn(movieDTOs.get(0));
		when(modelMapper.map(movies.get(1), MovieDTO.class)).thenReturn(movieDTOs.get(1));

		List<MovieDTO> actual = movieService.getMovies();

		assertEquals(movieDTOs, actual);
		verify(movieRepo).findAll();
		verify(modelMapper).map(movies.get(0), MovieDTO.class);
		verify(modelMapper).map(movies.get(1), MovieDTO.class);
	}

}
