package com.cognizant.movie.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoSqlImpl;
import com.cognizant.movie.model.Movie;

@WebServlet("/ShowEditMovieServlet")
public class ShowEditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowEditMovieServlet() {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MovieDaoSqlImpl movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		String movieid = request.getParameter("movieId");
		long movieId = Long.parseLong(movieid);
		Movie movie = movieDao.getMovie(movieId);
		System.out.println("Menu Item=" + movie);
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("edit-movie.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
