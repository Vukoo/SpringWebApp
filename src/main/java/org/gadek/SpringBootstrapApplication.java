package org.gadek;

import org.gadek.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootstrapApplication  {

	
	@Autowired
	MovieRepository movieRepository;
	static final String URL = "https://gturnquist-quoters.cfapps.io/api/random";


	public static void main(String[] args) {
		 RestTemplate restTemplate = new RestTemplate();
		 
	        String result = restTemplate.getForObject(URL, String.class);
	 
	        
		SpringApplication.run(SpringBootstrapApplication.class, args);
		System.out.println(result);
	}	

	

}

