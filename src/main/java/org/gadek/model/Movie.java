package org.gadek.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.context.annotation.Lazy;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
	@NotNull
	private String title;
	
	@NotNull
	@Min(1800)
	@Max(2030)
	private Long year;
	@NotNull
	private String director;
	@NotNull
	@Min(1)
	@Max(10)
	private Long rating;
	
	@Lazy(true)

	private Long languageId;
	

//	@Lazy(true)
//	@ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "languageId",referencedColumnName="id", nullable = false,insertable = false, updatable = false)
//	private Language language;
	

	public Movie() {
		}
	public Movie(Long movieId, String title,Long year, String director, Long rating) {
		this.movieId = movieId;
        this.title =title;
        this.year = year;
        this.director = director;
        this.rating = rating;
	}
	
	public Long getlanguageId() {
		return languageId;
	}

	public void setlanguageId(Long languageId) {
		this.languageId = languageId;
	}
	
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
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
