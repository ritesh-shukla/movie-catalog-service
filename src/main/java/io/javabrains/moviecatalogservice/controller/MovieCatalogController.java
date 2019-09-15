package io.javabrains.moviecatalogservice.controller;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.javabrains.moviecatalogservice.model.CatalogItem;
import io.javabrains.moviecatalogservice.model.Movie;
import io.javabrains.moviecatalogservice.model.Rating;
import io.javabrains.moviecatalogservice.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId")String userId)
	{
		//RestTemplate restTemplate=new RestTemplate();
		
		//UserRatings ur=restTemplate.getForObject("http://localhost:8083/rating/user/"+userId, UserRatings.class);
		UserRatings ur=restTemplate.getForObject("http://ratings-data-service/ratings/user/"+userId, UserRatings.class);
		//get all rated movie ids
		/*List<Rating> ratings=Arrays.asList(
				new Rating("1234", 4),
				new Rating("5678", 4)
				);*/
		
		return ur.getRatings().stream().map(rating ->{
			//Movie m=restTemplate.getForObject("http://localhost:8082/movie/"+rating.getMovieId(), Movie.class);	
			Movie m=restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
			return new CatalogItem(m.getName(),  "Test", String.valueOf(rating.getRaiting()));
			
			//Alternative WebClient way
			//Movie m= webClientBuilder.build().get().uri("http://localhost:8082/movie/"+rating.getMovieId()).retrieve().bodyToMono(Movie.class).block();
			//return new CatalogItem(m.getName(),  "Test", String.valueOf(rating.getRaiting()));
		}
		).collect(Collectors.toList());
			
		
		// for each movie id call movie info service
		
		//put them all together
		
		
		
	}
	
	/*
	Alternative WebClient way
	Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
	.retrieve().bodyToMono(Movie.class).block();
	*/
}
