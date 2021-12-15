package com.bae.movies.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.movies.domain.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:movie-schema.sql",
		"classpath:movie-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class MovieControllerIntergrationTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Movie testMovie = new Movie(null, "Lord Of The Rings", "Adventure", 2001, "Netflix");
		String testMovieAsJSON = this.mapper.writeValueAsString(testMovie);
		RequestBuilder req = post("/createMovie").content(testMovieAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		Movie testCreatedMovie = new Movie(2, "Lord Of The Rings", "Adventure", 2001, "Netflix");
		String testCreatedMovieAsJSON = this.mapper.writeValueAsString(testCreatedMovie);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testCreatedMovieAsJSON);
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		RequestBuilder request = get("/getAll");
		
		List<Movie> testAllMovies = List.of(new Movie(1, "Lord Of The Rings", "Adventure", 2001, "Netflix"));
		String testAllMoviesAsJSON = this.mapper.writeValueAsString(testAllMovies);
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testAllMoviesAsJSON);
		
		this.mvc.perform(request).andExpect(checkBody).andExpect(checkStatus);
	}

}
