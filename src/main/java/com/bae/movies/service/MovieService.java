package com.bae.movies.service;

import java.util.List;

import com.bae.movies.domain.Movie;

public interface MovieService {
	
	Movie createMovie(Movie movie);
	
	List<Movie> getAllMovies();

	Movie getMovie(Integer id);

	Movie replaceMovie(Integer id, Movie newMovie);

	void removeMovie(Integer id);
	
//	Movie findMovieName(String movieName);
//	
//	List<Movie> findByGenre(String genre);
//	
//	List<Movie> findByYearReleased(Integer yearReleased);
//	
//	List<Movie> findByAvailableOn(String availableOn);
}
