package org.gadek.service;

import org.gadek.model.Quotes;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



public class QuoteService {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
	
	public String getRandomQuote(RestTemplate restTemplate) throws Exception {
		Quotes quote = restTemplate.getForObject(
				"http://gturnquist-quoters.cfapps.io/api/random", Quotes.class);
		String tekst;
		tekst = quote.getValue().getQuote();
		return tekst;
	}
}
