package com.qa.movie_project.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewMovieDTO {

	@NotNull
	@NotBlank
	private String title;

	@NotNull
	private String genre;

	@NotNull
	private Integer releaseYear;

	@NotNull
	private int runtime;

	public NewMovieDTO() {
		super();
	}

	public NewMovieDTO(String title, String genre, Integer releaseYear, int runtime) {
		super();
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.runtime = runtime;
	}

}
