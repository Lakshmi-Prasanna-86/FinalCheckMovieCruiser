package com.cognizant.movie.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

/**
 * @author Prasanna
 *
 */
public class MovieDaoCollectionImplTest {
	public static void main(String[] args) throws ParseException {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovie();
	}

	public static void testGetMovieListAdmin() {
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		System.out.println("Movie List Admin:\n"
				+ movieDaoCollectionImpl.getMovieListAdmin());
		List<Movie> movies = movieDaoCollectionImpl.getMovieListAdmin();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
	}

	public static void testGetMovieListCustomer() {
		MovieDaoCollectionImpl movieDaoCollectionImpl = new MovieDaoCollectionImpl();
		System.out.println("Movie List Customer:\n"
				+ movieDaoCollectionImpl.getMovieListCustomer());
		List<Movie> movies = movieDaoCollectionImpl.getMovieListCustomer();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
	}

	public static void testModifyMovie() throws ParseException {
		Movie movie = new Movie(2, "The Joker", 1854623412l, true,
				DateUtil.convertToDate("02/10/2019"), "Thriller", true);
		MovieDaoCollectionImpl movieCollectionImpl = new MovieDaoCollectionImpl();
		MovieDao movieDao = movieCollectionImpl;
		movieDao.modifyMovie(movie);
		System.out.println("Modified Movie details are:\n"
				+ movieDao.getMovie(2));
	}

	public static void testGetMovie() {

		// System.out.println(.getMenuItem(2));
	}
}
