package com.cognizant.movie.dao;

/**
 * @author Prasanna
 *
 */
@SuppressWarnings("serial")
public class FavoritesEmptyException extends Exception {
	private String message;

	public FavoritesEmptyException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
