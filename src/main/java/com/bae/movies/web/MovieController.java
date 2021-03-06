package com.bae.movies.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.movies.domain.Movie;
import com.bae.movies.service.MovieService;

@RestController
@CrossOrigin
public class MovieController {

	private MovieService service;

	@Autowired
	public MovieController(MovieService service) {
		super();
		this.service = service;
	}

	@PostMapping("/createMovie")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		Movie createdMovie = this.service.createMovie(movie);
		ResponseEntity<Movie> response = new ResponseEntity<Movie>(createdMovie, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok(this.service.getAllMovies());
	}

	@GetMapping("/get/{id}")
	public Movie getMovie(@PathVariable Integer id) {
		Movie getId = service.getMovie(id);
		return getId;
	}

	@PutMapping("/replace/{id}")
	public ResponseEntity<Movie> replaceMovie(@PathVariable Integer id, @RequestBody Movie newMovie) {
		Movie body = this.service.replaceMovie(id, newMovie);

		ResponseEntity<Movie> response = new ResponseEntity<Movie>(body, HttpStatus.ACCEPTED);
		return response;
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Movie> removeMovie(@PathVariable Integer id) {
		this.service.removeMovie(id);
		ResponseEntity<Movie> response = new ResponseEntity<Movie>(HttpStatus.NO_CONTENT);
		return response;
	}
	
	@GetMapping("/getByGenre/{genre}")
	public ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
		List<Movie> found = this.service.getByGenre(genre);
		return ResponseEntity.ok(found);
	}
	
	@GetMapping("availableOn/{platform}")
	public ResponseEntity<List<Movie>> availableOn(@PathVariable String platform) {
		List<Movie> found = this.service.getByAvailableOn(platform);
		return ResponseEntity.ok(found);
	}
	
	@GetMapping("getByName/{movieName}")
	public Movie getName(@PathVariable String movieName) {
		Movie getMovieName = service.getMovieName(movieName);
		return getMovieName;
	}
}
