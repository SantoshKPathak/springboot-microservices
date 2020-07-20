/**
 * 
 */
package com.santoshpathak.learnings.microservices.moviecatalogservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.santoshpathak.learnings.microservices.moviecatalogservice.models.CatalogItem;
import com.santoshpathak.learnings.microservices.moviecatalogservice.models.Movie;
import com.santoshpathak.learnings.microservices.moviecatalogservice.models.Rating;
import com.santoshpathak.learnings.microservices.moviecatalogservice.models.UserRatings;

/**
 * @author santoshpathak
 *
 */

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	/**
	* WebClient is going to replace RestTemplate
	*/		
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	@Value("${api.ratingsdatservice.url}")
	private String ratingsDataServiceAPI;
	
	@Value("${api.movieinfoservice.url}")
	private String movieInfoServiceAPI;
	
	
	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		//get all rated movies Id
		
		UserRatings userRatings = restTemplate.getForObject(ratingsDataServiceAPI+userId, UserRatings.class);
		
		//for each movieId, call movie Info Service and get the details
		
		return userRatings.getRatings().stream().map(rating ->{
			Movie movie = restTemplate.getForObject(movieInfoServiceAPI+rating.getMovieId(), Movie.class);
			 return new CatalogItem(movie.getMovieName(), movie.getMovieOverview(), rating.getRating());
			
		}).collect(Collectors.toList());
		
		//put them all together
		
	}
	
	//@GetMapping("/{userId}")
	public List<CatalogItem> getCatalogByWebClient(@PathVariable("userId") String userId){
		
		//get all rated movies Id
		
		List<Rating> ratings = Arrays.asList(
									new Rating("1234", 4),
									new Rating("5678", 3));
		
		//for each movieId, call movie Info Service and get the details
		
		return ratings.stream().map(rating ->{
			Movie movie = webClientBuilder
							.build()
							.get()
							.uri("http://localhost:8082/movies/"+rating.getMovieId())
							.retrieve()
							.bodyToMono(Movie.class) //means map the response body to this class
							.block(); // since its asynchronus so dont proceed further until response. 
			 return new CatalogItem(movie.getMovieName(), "Test", rating.getRating());
			
		}).collect(Collectors.toList());
		
	}

}
