package org.gadek.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.gadek.model.Movie;
import org.springframework.jdbc.core.RowMapper;

public class MovieMapper implements RowMapper<Movie> {
	
	 public static final String SELECT_SQL = "Select u.movie_id, u.title, u.year, u.director, rating From movie u ";

	 
	 @Override
	    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
	 
	        Long movieID = rs.getLong("movie_id");
	        String title = rs.getString("title");
	        String director = rs.getString("director");
	        Long rating =  rs.getLong("rating");
	        Long year = rs.getLong("year");
	        return new Movie(movieID, title, year,director,rating);
	    }
}
