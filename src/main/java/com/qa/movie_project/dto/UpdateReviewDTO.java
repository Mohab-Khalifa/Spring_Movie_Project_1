package com.qa.movie_project.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateReviewDTO {

	@NotNull
	@Min(1)
	@Max(10)
	private int rating;

	@Size(min = 0, max = 250, message = "The comments must contain a minimum of 10 characters and maximum of 250 characters")
	private String comment;

}
