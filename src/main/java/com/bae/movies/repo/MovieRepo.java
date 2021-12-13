package com.bae.movies.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bae.movies.domain.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>{
	
//	Movie findMovieName(String movieName);
//	
	List<Movie> findByGenre(String genre);
//	
//	List<Movie> findByYearReleased(Integer yearReleased);
//	
//	List<Movie> findByAvailableOn(String availableOn);

}
