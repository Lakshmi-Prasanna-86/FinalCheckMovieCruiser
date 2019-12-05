
/* 1.	View Movie List Admin (TYUC001)
   a.	Frame insert scripts to add data into movie table.*/
  insert into movie values(1,'Avatar','2787965087','yes','2017-03-15','Science Fiction','yes');
  insert into movie values(2,'The Avengers','1518812988','yes','2017-12-23','Superhero','no');
  insert into movie values(3,'Titanic','2187463944','yes','2017-08-21','Romance','no');
  insert into movie values(4,'Jurrasic World','1617713208','no','2017-07-02','Science Fiction','yes');
  insert into movie values(5,'Avengers:End Game','2750760348','yes','2022-11-02','Superhero','yes');


/* b.	Frame SQL query to get all menu items */

  select * from movie;

/* 2.	View Movie List Customer (TYUC002)
   a.	Frame SQL query to get all movies which after launch date and is active.*/

  select * from movie where movie_date_of_launch<=now() and movie_active='yes';


/* 3.	Edit Movie (TYUC003)
   a.	Frame SQL query to get a movie based on Movie Id */

   select * from movie where movie_id=1;

/* b.	Frame update SQL movie table to update all the columns values based on Movie Id */
   
   update movie set movie_title='bahubali',movie_box_office='8878952824',movie_active='yes',movie_date_of_launch='2019-05-10',movie_genre='Drama' where movie_id=4;

/*4.	Add to Favorite (TYUC004) */

  insert into favorite values(1,1,1);
  insert into favorite values(2,1,3);
  insert into favorite values(3,1,5);

/* 5.	View Favorite (TYUC005)
   a.	Frame SQL query to get all movies in a particular user’s favorites */

  select * from movie inner join favorite on movie.movie_id=favorite.movie_movie_id and favorite.user_user_id=1;

/* b.	Frame SQL query to get the total number of movies in a particular user’s Favorites */

  select COUNT(movie_id) from movie inner join favorite on movie.movie_id=favorite.movie_movie_id and favorite.user_user_id=1;

/* 6.	Remove movie from favorite(TYUC006)
   a.	Frame SQL query to remove a movie from favorites based on User Id and Movie Id */

   delete from favorite where user_user_id=1 and movie_movie_id=1;






