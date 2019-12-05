package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;

/**
 * @author Prasanna
 *
 */
public interface MovieDao {
	public List<Movie> getMovieListAdmin();

	public List<Movie> getMovieListCustomer();

	public void modifyMovie(Movie movie);

	public Movie getMovie(long movieId);
}
