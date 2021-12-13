package com.bae.movies.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.movies.domain.Movie;
import com.bae.movies.repo.MovieRepo;

@Service
public class MovieServiceDB implements MovieService{
	
	private MovieRepo repo;
	
	@Autowired
	public MovieServiceDB(MovieRepo repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public Movie createMovie(Movie movie) {
		Movie created = this.repo.save(movie);
		return created;
	}

	@Override
	public List<Movie> getAllMovies() {
		return this.repo.findAll();
	}

	@Override
	public Movie getMovie(Integer id) {
		Optional<Movie> idFound = this.repo.findById(id);
		return idFound.get();
	}

	@Override
	public Movie replaceMovie(Integer id, Movie newMovie) {
		Movie current = this.repo.findById(id).get();
		
		current.setMovieName(newMovie.getMovieName());
		current.setGenre(newMovie.getGenre());
		current.setYearReleased(newMovie.getYearReleased());
		current.setAvailableOn(newMovie.getAvailableOn());
		
		Movie updated = this.repo.save(current);
		return updated;
	}

	@Override
	public void removeMovie(Integer id) {
		this.repo.deleteById(id);
		
		
	}
	
	//ADD THESE LATER

//	@Override
//	public Movie findMovieName(String movieName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Movie> findByGenre(String genre) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Movie> findByYearReleased(Integer yearReleased) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Movie> findByAvailableOn(String availableOn) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}