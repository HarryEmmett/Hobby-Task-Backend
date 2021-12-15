package com.bae.movies.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true)
	private String movieName;
	@Column(nullable = false)
	private String genre;
	@Column(nullable = false)
	private Integer yearReleased;
	@Column(nullable = false)
	private String availableOn;

	public Movie(Integer id, String movieName, String genre, Integer yearReleased, String availableOn) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.genre = genre;
		this.yearReleased = yearReleased;
		this.availableOn = availableOn;
	}

	public Movie() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(Integer yearReleased) {
		this.yearReleased = yearReleased;
	}

	public String getAvailableOn() {
		return availableOn;
	}

	public void setAvailableOn(String availableOn) {
		this.availableOn = availableOn;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", movieName=" + movieName + ", genre=" + genre + ", yearReleased=" + yearReleased
				+ ", availableOn=" + availableOn + "]";
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(availableOn, genre, id, movieName, yearReleased);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Movie other = (Movie) obj;
//		return Objects.equals(availableOn, other.availableOn) && Objects.equals(genre, other.genre)
//				&& Objects.equals(id, other.id) && Objects.equals(movieName, other.movieName)
//				&& Objects.equals(yearReleased, other.yearReleased);
//	}

}
