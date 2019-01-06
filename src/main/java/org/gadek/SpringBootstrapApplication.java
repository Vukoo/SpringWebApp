package org.gadek;

import org.gadek.model.Movie;
import org.gadek.model.Quotes;
import org.gadek.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class SpringBootstrapApplication implements CommandLineRunner {

	
	@Autowired
	MovieRepository movieRepository;
	//
   // private static final Logger log = LoggerFactory.getLogger(SpringBootstrapApplication.class);


	public static void main(String[] args) {

		SpringApplication.run(SpringBootstrapApplication.class, args);
	}	
		//testing purpose	
	@Override
	public void run(String... arg0) throws Exception {
		for(Movie product : movieRepository.findAll()) {
			System.out.println("Id: " + product.getMovieID());
			System.out.println("Nazwa: " + product.getTitle());
			System.out.println("Rok produkcji: " + product.getYear());
			System.out.println("Reżyser: " + product.getDirector());
			System.out.println("Ocena: " + product.getRating());

			System.out.println("================================");
			
			
		}
	}
	
	
	//Simple builder for quote handle
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quotes quote = restTemplate.getForObject(
					"http://gturnquist-quoters.cfapps.io/api/random", Quotes.class);
			String tekst;
			tekst = quote.getValue().getQuote();
			System.out.println(tekst);
		};
	}
	

}

