package org.gadek;

import org.gadek.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootstrapApplication  {

	
	@Autowired
	MovieRepository movieRepository;
	//
   // private static final Logger log = LoggerFactory.getLogger(SpringBootstrapApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(SpringBootstrapApplication.class, args);
	}	

	

}

