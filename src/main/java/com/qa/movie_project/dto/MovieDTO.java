package com.qa.movie_project.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MovieDTO {

	private int id;

	@NotNull
	@NotBlank
	private String title;

	@NotNull
	private String genre;

	@NotNull
	private Integer releaseYear;

	@NotNull
	private int runtime;

}
