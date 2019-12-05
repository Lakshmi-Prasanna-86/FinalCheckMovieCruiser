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
import com.cognizant.movie.model.Movie;

@WebServlet("/ShowFavoritesServlet")
public class ShowFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowFavoritesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		long userId = 1;
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		FavoritesDao favoritesDao = favoritesDaoSqlImpl;
		try {
			List<Movie> movieList = favoritesDao.getAllFavorites(userId);
			request.setAttribute("favoritesMovieList", movieList);
			request.getRequestDispatcher("favorites.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.getRequestDispatcher("favorites-empty.jsp").forward(
					request, response);
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
