package com.cognizant.movie.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.movie.model.Movie;

/**
 * @author prasanna
 */
public class MovieDaoSqlImpl implements MovieDao {
	public List<Movie> getMovieListAdmin() {
		Connection connection = ConnectionHandler.getConnection();
		List<Movie> movieList = new ArrayList<Movie>();
		ResultSet resultSet;
		boolean hasTeaserFlg;
		boolean activeFlg;
		try {
			if (connection != null) {
				PreparedStatement preparedStatement = connection
						.prepareStatement("select movie_id,movie_title,movie_box_office,movie_active,movie_date_of_launch,movie_genre,movie_has_teaser from movie");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					int movieId = resultSet.getInt("movie_id");
					String title = resultSet.getString("movie_title");
					long box_office = resultSet.getLong("movie_box_office");
					String active = resultSet.getString("movie_active");
					Date dateOfLaunch = resultSet
							.getDate("movie_date_of_launch");
					String genre = resultSet.getString("movie_genre");
					String hasTeaser = resultSet.getString("movie_has_teaser");
					if (hasTeaser != null && hasTeaser.equals("yes")) {
						hasTeaserFlg = true;
					} else {
						hasTeaserFlg = false;
					}
					if (active != null && active.equals("yes")) {
						activeFlg = true;
					} else {
						activeFlg = false;
					}

					Movie movie = new Movie(movieId, title, box_office,
							activeFlg, dateOfLaunch, genre, hasTeaserFlg);
					movieList.add(movie);

				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	public List<Movie> getMovieListCustomer() {
		Connection connection = ConnectionHandler.getConnection();
		List<Movie> movieList = new ArrayList<Movie>();
		ResultSet resultSet;
		boolean hasTeaserFlg;
		boolean activeFlg;
		try {
			if (connection != null) {
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from movie where movie_date_of_launch<=now() and movie_active='yes'");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					int movieId = resultSet.getInt(1);
					String title = resultSet.getString(2);
					long box_office = resultSet.getLong(3);
					String active = resultSet.getString(4);
					Date dateOfLaunch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);
					if (hasTeaser != null && hasTeaser.equals(8)) {
						hasTeaserFlg = true;
					} else {
						hasTeaserFlg = false;
					}
					if (active != null && active.equals(8)) {
						activeFlg = true;
					} else {
						activeFlg = false;
					}

					Movie movie = new Movie(movieId, title, box_office,
							activeFlg, dateOfLaunch, genre, hasTeaserFlg);
					movieList.add(movie);

				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	public void modifyMovie(Movie movie) {
		Connection connection = ConnectionHandler.getConnection();
		String sql = "update movie set movie_title=?,movie_box_office=?,movie_active=?,movie_date_of_launch=?,movie_genre=?,movie_has_teaser=? where movie_id=?";
		try {
			if (connection != null) {
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql);
				preparedStatement.setString(1, movie.getTitle());
				preparedStatement.setLong(2, movie.getBoxOffice());
				if (movie.isActive())
					preparedStatement.setString(3, "yes");
				else
					preparedStatement.setString(3, "no");
				preparedStatement.setDate(4, new java.sql.Date(movie
						.getDateOfLaunch().getTime()));
				preparedStatement.setString(5, movie.getGenre());
				if (movie.isHasTeaser())
					preparedStatement.setString(6, "yes");
				else
					preparedStatement.setString(6, "no");
				preparedStatement.setLong(7, movie.getId());
				preparedStatement.executeUpdate();

			}
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		ConnectionHandler ch = new ConnectionHandler();
		@SuppressWarnings("static-access")
		Connection connection = ch.getConnection();
		PreparedStatement preparedStatement;
		boolean hasTeaserFlg;
		boolean activeFlg;
		ResultSet resultSet;
		Movie movie = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movie where movie_id=?");
				preparedStatement.setLong(1, movieId);

				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					String title = resultSet.getString(2);
					long box_office = resultSet.getLong(3);
					String active = resultSet.getString(4);
					Date dateOfLaunch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);
					if (hasTeaser != null && hasTeaser.equals(8)) {
						hasTeaserFlg = true;
					} else {
						hasTeaserFlg = false;
					}
					if (active != null && active.equals(8)) {
						activeFlg = true;
					} else {
						activeFlg = false;
					}
					movie = new Movie(movieId, title, box_office, activeFlg,
							dateOfLaunch, genre, hasTeaserFlg);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return movie;

	}

}
