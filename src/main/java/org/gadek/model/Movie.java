package org.gadek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Movie {
	@Id
    @GeneratedValue
    @Column(nullable = false)
    private Long movieID;
	@NotNull
	@Column 
	private String title;
	
	@NotNull
	@Column 
	private Long year;
	@NotNull
	@Column
	private String director;
	@NotNull
	@Column
	@Min(1)
	@Max(10)
	private Long rating;
	
	public Movie() {
		
	}
	
	public Movie(Long movieID, String title,Long year, String director, Long rating) {
		this.movieID = movieID;
        this.title =title;
        this.year = year;
        this.director = director;
        this.rating = rating;
	}
	
	public Long getMovieID() {
		return movieID;
	}
	public void setMovieID(Long movieID) {
		this.movieID = movieID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getYear() {
		return year;
	}
	public void setYear(Long year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Long getRating() {
		return rating;
	}
	public void setRating(Long rating) {
		this.rating = rating;
	}
	

}
