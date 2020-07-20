/**
 * 
 */
package com.santoshpathak.learnings.microservices.movieinfoservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.santoshpathak.learnings.microservices.movieinfoservice.models.Movie;
import com.santoshpathak.learnings.microservices.movieinfoservice.models.MovieSummary;

/**
 * @author santoshpathak
 *
 */
@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	
	@Value("${themoviedb.api_key}")
	private String api_key;
	
	@Value("${themoviedb.url}")
	private String moviedb_url;
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * This method calls external API themoviedb to retrieve the movie details for a specific movieID
	 * 
	 * @param movieId
	 * @return
	 */
	@GetMapping("/{movieId}")
	public Movie getMovieInfos(@PathVariable("movieId") String movieId) {
		
		MovieSummary movieSummary = restTemplate.getForObject(moviedb_url+movieId+"?api_key="+api_key, MovieSummary.class);
		
		return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
	}
}
