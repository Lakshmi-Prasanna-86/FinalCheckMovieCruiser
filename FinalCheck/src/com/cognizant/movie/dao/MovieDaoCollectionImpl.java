package com.cognizant.movie.dao;

/**
 * @author Prasanna
 *
 */
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.Movie;
import com.cognizant.movie.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private List<Movie> movieList;

	public MovieDaoCollectionImpl() {
		super();
		if (movieList == null) {
			try {
				movieList = new ArrayList<Movie>();
				movieList.add(new Movie(1, "Avatar", 2787965087l, true,
						DateUtil.convertToDate("15/03/2017"),
						"Science Fiction", true));
				movieList.add(new Movie(2, "The Avengers", 1518812988l, true,
						DateUtil.convertToDate("23/12/2017"), "Superhero",
						false));
				movieList
						.add(new Movie(3, "Titanic", 2187463944l, true,
								DateUtil.convertToDate("21/08/2018"),
								"Romance", false));
				movieList.add(new Movie(4, "Jurassic World", 1671713208, false,
						DateUtil.convertToDate("02/07/2017"),
						"Science Fiction", true));
				movieList.add(new Movie(5, "Avengers:End Game", 2750760348l,
						true, DateUtil.convertToDate("02/11/2022"),
						"Superhero", true));
			} catch (ParseException pe) {
				System.out.println("ParseException " + pe.getMessage());
			}
		}
	}

	public List<Movie> getMovie() {
		return movieList;
	}

	public void setMenuItem(List<Movie> movie) {
		this.movieList = movie;
	}

	public List<Movie> getMovieListAdmin() {
		return movieList;
	}

	public List<Movie> getMovieListCustomer() {
		List<Movie> movieListCust = new ArrayList<Movie>();
		Date today = new Date();
		for (Movie mov : movieList) {
			if (mov.getDateOfLaunch().getTime() <= today.getTime()
					&& mov.isActive()) {
				movieListCust.add(mov);
			}
		}
		return movieListCust;
	}

	public void modifyMovie(Movie movie) {
		for (Movie mov : movieList) {
			if (movie.getId() == mov.getId()) {
				mov.setTitle(movie.getTitle());
				mov.setGenre(movie.getGenre());
				mov.setDateOfLaunch(movie.getDateOfLaunch());
				mov.setHasTeaser(movie.isHasTeaser());
				mov.setBoxOffice(movie.getBoxOffice());
				mov.setActive(movie.isActive());
			}
		}
	}

	@Override
	public Movie getMovie(long movieId) {
		for (Movie movie : movieList) {
			if (movieId == movie.getId()) {
				return movie;
			}
		}
		return null;
	}
}
