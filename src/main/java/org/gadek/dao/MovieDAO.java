package org.gadek.dao;

import java.util.List;


import javax.sql.DataSource;

import org.gadek.mapper.MovieMapper;
import org.gadek.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class MovieDAO extends JdbcDaoSupport {
	
	 @Autowired
	    public MovieDAO(DataSource dataSource) {
	      this.setDataSource(dataSource);
	    }
	   public List<Movie> getMovie() {
	    	String sql = MovieMapper.SELECT_SQL;
	        Object[] params = new Object[] {};
	        MovieMapper mapper = new MovieMapper();
	        List<Movie> list = this.getJdbcTemplate().query(sql, params, mapper);
	        return list;
	    }
	
}
