package com.qa.movie_project.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qa.movie_project.entity.Movie;
import com.qa.movie_project.entity.Review;
import com.qa.movie_project.repo.MovieRepo;
import com.qa.movie_project.repo.ReviewRepo;

@Profile("dev")
@Configuration
public class DevStartupListener {

	private MovieRepo movieRepo;
	private ReviewRepo reviewRepo;

	@Autowired
	public DevStartupListener(MovieRepo movieRepo, ReviewRepo reviewRepo) {
		this.movieRepo = movieRepo;
		this.reviewRepo = reviewRepo;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		List<Movie> movies = movieRepo.saveAll(
				List.of(new Movie("Inception", "Thriller", 2010, 148), new Movie("White Chicks", "Comedy", 2004, 109)));

		Movie movie = movies.stream().filter(m -> m.getTitle().equals("Inception")).findFirst().orElse(null);

		List<Review> reviews = reviewRepo.saveAll(List.of(new Review(10, "10/10 is all you need to know!", movie),
				new Review(5, "This movie is mediocre, would not recommend for cinema", movie),
				new Review(8, "This movie is top tier", movie)));

	}

}
