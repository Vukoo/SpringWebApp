package org.gadek.service;

import java.util.List;

import org.gadek.model.Movie;
import org.gadek.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
    private MovieRepository movieRepository;
	
	 @Override
	    public List<Movie> findAllUser() {
	        return (List<Movie>) movieRepository.findAll();
	    }
	
}
