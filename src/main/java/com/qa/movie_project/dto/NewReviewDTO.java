package com.qa.movie_project.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NewReviewDTO {

	@NotNull
	@Min(1)
	@Max(10)
	private int rating;

	@Size(min = 0, max = 250, message = "The comments must contain a minimum of 10 characters and maximum of 250 characters")
	private String comment;

	public NewReviewDTO() {

	}

	public NewReviewDTO(int rating, String comment) {
		super();
		this.rating = rating;
		this.comment = comment;
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

}
