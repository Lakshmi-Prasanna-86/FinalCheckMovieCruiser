package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.FavoritesDao;
import com.cognizant.movie.dao.FavoritesDaoSqlImpl;
import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoSqlImpl;
import com.cognizant.movie.model.Movie;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToFavoritesServlet")
public class AddToFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddToFavoritesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long userId = 1;
		String movieid = request.getParameter("movieId");
		System.out.println(movieid);
		long movieId = Long.parseLong(movieid);
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		FavoritesDao favoritesDao = favoritesDaoSqlImpl;
		favoritesDao.addFavorites(userId, movieId);
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		List<Movie> movieList = movieDao.getMovieListCustomer();
		request.setAttribute("addFavoritesStatus", true);
		request.setAttribute("customerMovieList", movieList);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(
				request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
