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

	public MovieDTO() {
		super();
	}

	public MovieDTO(int id, String title, String genre, Integer releaseYear, int runtime) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.runtime = runtime;
	}

	public MovieDTO(String title, String genre, Integer releaseYear, int runtime) {
		super();
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.runtime = runtime;
	}

}
