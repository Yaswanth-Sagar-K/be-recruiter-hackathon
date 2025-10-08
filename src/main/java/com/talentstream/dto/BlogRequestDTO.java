package com.talentstream.dto;

import java.util.UUID;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BlogRequestDTO {

	@NotNull(message = "The 'id' field must be provided")
	private UUID id;

	@Size(min = 3, max = 100, message = "Author name must be between 3 and 100 characters")
	private String author;


	@NotNull(message = "The 'isActive' field must be provided")
	private Boolean isActive;

	// Getters and Setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
