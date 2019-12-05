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

@WebServlet("/RemoveFavoritesServlet")
public class RemoveFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveFavoritesServlet() {
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
		favoritesDao.removeFavorites(userId, movieId);
		try {
			List<Movie> movieList = favoritesDao.getAllFavorites(userId);
			request.setAttribute("removeFavoritesStatus", true);
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
