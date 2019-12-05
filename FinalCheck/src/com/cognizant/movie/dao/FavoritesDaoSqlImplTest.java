package com.cognizant.movie.dao;

/**
 * @author prasanna
 */
public class FavoritesDaoSqlImplTest {

	public static void main(String[] args) throws FavoritesEmptyException {
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
		favoritesDaoSqlImpl.addFavorites(1, 3);
		favoritesDaoSqlImpl.getAllFavorites(1);
		favoritesDaoSqlImpl.removeFavorites(1, 2);
	}

}
