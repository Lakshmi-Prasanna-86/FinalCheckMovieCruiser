package com.cognizant.movie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movie;

/**
 * @author prasanna
 */
public class FavoritesDaoSqlImpl implements FavoritesDao {
	public void addFavorites(long userId, long movieId) {
		Connection conn = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("insert into favorite values(default,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				System.out
				.println("userId: " + userId + " movieId: " + movieId);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeFavorites(long userId, long movieId) {
		Connection connection = null;
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("delete from favorite where user_user_id=? and movie_movie_id=?");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieId);
				preparedStatement.executeUpdate();
				System.out.println("Record deleted successfully");
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

	@Override
	public List<Movie> getAllFavorites(long userid)
			throws FavoritesEmptyException {
		Connection connection = null;
		List<Movie> movieList = new ArrayList<Movie>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		Movie movie = null;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {

				Favorites favorites = new Favorites(movieList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
				.append("SELECT movie.movie_id, movie.movie_title, movie.movie_box_office ,movie.movie_active,movie.movie_date_of_launch,movie.movie_genre, movie.movie_has_teaser FROM movie ")
				.append("INNER JOIN favorite ON movie.movie_id = favorite.movie_movie_id WHERE favorite.user_user_id = ?");
				preparedStatement = connection.prepareStatement(sqlBuffer
						.toString());
				preparedStatement.setLong(1, userid);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					int movieId = resultSet.getInt(1);
					String title = resultSet.getString(2);
					long box_office = resultSet.getLong(3);
					String active = resultSet.getString(4);
					Date date_of_launch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);

					if (active != null && active.equals("yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					movie = new Movie(movieId, title, box_office, activeFlag,
							date_of_launch, genre, hasTeaserFlag);
					movieList.addAll(movieList);
					System.out.println("added item:" + movie);
				}
				favorites.setMovieList(movieList);
				favorites.setTotal(getTotalFavorites(userid, connection));
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
		return movieList;
	}

	private int getTotalFavorites(long userId, Connection conn) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		int total = 0;
		List<Movie> movieList = new ArrayList<Movie>();
		try {
			if (conn != null) {
				@SuppressWarnings("unused")
				Favorites favorites = new Favorites(movieList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
				.append("select COUNT(movie_id) from movie inner join favorite on movie.movie_id=favorite.movie_movie_id ")
				.append("WHERE favorite.user_user_id = ?");
				preparedStatement = conn.prepareStatement(sqlBuffer.toString());
				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					total = resultSet.getInt(1);
				}
				System.out.println("Total Number of Favorites : " + total);
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return total;
	}
}
