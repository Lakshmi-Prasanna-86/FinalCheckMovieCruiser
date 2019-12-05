package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;

/**
 * @author Prasanna
 *
 */
public interface FavoritesDao {
	public void addFavorites(long userId, long movieId);

	public void removeFavorites(long userId, long movieId);

	List<Movie> getAllFavorites(long userid) throws FavoritesEmptyException;
}
