package com.cognizant.movie.dao;

import java.util.List;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

/**
 * @author prasanna
 */
public class MovieDaoSqlImplTest {
	public static void main(String[] args) {
		testGetMenuItemsAdminSql();
		testGetMenuItemsCustomerSql();
		testModifyItems();
	}

	static void testGetMenuItemsAdminSql() {
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		List<Movie> movieList = movieDaoSqlImpl.getMovieListAdmin();
		for (Movie movie : movieList) {
			System.out.println("Movie: " + movie);
		}
		System.out
		.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	static void testGetMenuItemsCustomerSql() {

		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		List<Movie> movieList = movieDaoSqlImpl.getMovieListCustomer();
		for (Movie movie : movieList) {
			System.out.println("Movie: " + movie);
		}
		System.out
		.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}

	static void testModifyItems() {
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		try {
			Movie movie = new Movie(3, "Shutter Island", 765478924, false,
					DateUtil.convertToDate("11/12/2018"), "Drama", true);
			movieDaoSqlImpl.modifyMovie(movie);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
