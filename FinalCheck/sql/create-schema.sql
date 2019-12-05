/* script to create movie_cruiser database */
CREATE DATABASE IF NOT EXISTS movie_cruiser;

/* script to create change to truyum database; */
USE movie_cruiser;

/*script to create table user */
CREATE  TABLE IF NOT EXISTS user (
  user_id INT NOT NULL AUTO_INCREMENT ,
  user_name VARCHAR(45) NOT NULL ,
  PRIMARY KEY (user_id) ); 

/*script to create table movie */  
CREATE  TABLE IF NOT EXISTS movie (
  movie_id INT NOT NULL AUTO_INCREMENT ,
  movie_title VARCHAR(100) NOT NULL ,
  movie_box_office MEDIUMTEXT NOT NULL ,
  movie_active VARCHAR(3) NOT NULL ,
  movie_date_of_launch DATE NOT NULL ,
  movie_genre VARCHAR(45) NOT NULL ,
  movie_has_teaser VARCHAR(3) NOT NULL ,
  PRIMARY KEY (movie_id) );

/*script to create table favorite */  
CREATE  TABLE IF NOT EXISTS favorite (
  fav_id INT NOT NULL ,
  user_user_id INT NOT NULL ,
  movie_movie_id INT NOT NULL ,
  PRIMARY KEY (fav_id) ,
  CONSTRAINT user_user_id
    FOREIGN KEY (user_user_id )
    REFERENCES user (user_id ),
  CONSTRAINT movie_movie_id
    FOREIGN KEY (movie_movie_id )
    REFERENCES movie(movie_id )
  );

