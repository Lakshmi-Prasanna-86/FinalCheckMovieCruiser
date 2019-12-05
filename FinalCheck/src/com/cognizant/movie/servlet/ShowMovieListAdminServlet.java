package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieDaoSqlImpl;
import com.cognizant.movie.model.Movie;

@WebServlet("/ShowMovieListAdminServlet")
public class ShowMovieListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MovieDaoSqlImpl movieDaoSqlImpl;

	public void init() {
	}

	public ShowMovieListAdminServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		movieDaoSqlImpl = new MovieDaoSqlImpl();
		MovieDao movieDao = movieDaoSqlImpl;
		List<Movie> movieList = movieDao.getMovieListAdmin();
		request.setAttribute("adminMovieList", movieList);
		request.getRequestDispatcher("movie-list-admin.jsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
