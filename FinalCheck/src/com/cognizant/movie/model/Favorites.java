package com.cognizant.movie.model;

import java.util.List;

/**
 * @author Prasanna
 *
 */
public class Favorites {
	private List<Movie> movieList;
	private long total;

	public Favorites() {
		super();
	}

	public Favorites(List<Movie> movieList, long total) {
		super();
		this.movieList = movieList;
		this.total = total;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String toString() {
		return "Favorites [movieList=" + movieList + ", total=" + total + "]";
	}

}
