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

}
