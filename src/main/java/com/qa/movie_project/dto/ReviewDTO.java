package com.qa.movie_project.dto;

import java.time.LocalDate;

public class ReviewDTO {

	private int id;

	private int rating;

	private String comment;

	private MovieDTO movieDTO;

	private LocalDate postedAt;

	public ReviewDTO() {

	}

	public ReviewDTO(int id, int rating, String comment) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public MovieDTO getMovieDTO() {
		return movieDTO;
	}

	public void setMovieDTO(MovieDTO movieDTO) {
		this.movieDTO = movieDTO;
	}

	public LocalDate getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(LocalDate postedAt) {
		this.postedAt = postedAt;
	}

}
