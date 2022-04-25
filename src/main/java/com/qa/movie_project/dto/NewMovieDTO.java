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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

}
