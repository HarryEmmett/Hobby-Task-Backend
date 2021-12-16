package com.bae.movies.service;

import java.util.List;

import com.bae.movies.domain.Movie;

public interface MovieService {
	
	Movie createMovie(Movie movie);
	
	List<Movie> getAllMovies();

	Movie getMovie(Integer id);

	Movie replaceMovie(Integer id, Movie newMovie);

	void removeMovie(Integer id);
	
	Movie getMovieName(String movieName);
	
	List<Movie> getByGenre(String genre);
	
	List<Movie> getByAvailableOn(String availableOn);
}
