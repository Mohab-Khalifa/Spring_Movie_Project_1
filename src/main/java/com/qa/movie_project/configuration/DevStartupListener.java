package com.qa.movie_project.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.qa.movie_project.repo.MovieRepo;
import com.qa.movie_project.repo.ReviewRepo;

@Profile("dev")
@Configuration
public class DevStartupListener {

	private MovieRepo movieRepo;
	private ReviewRepo reviewRepo;

}
