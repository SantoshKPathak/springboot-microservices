/**
 * 
 */
package com.santoshpathak.learnings.microservices.ratingdataservice.reources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santoshpathak.learnings.microservices.ratingdataservice.models.Rating;
import com.santoshpathak.learnings.microservices.ratingdataservice.models.UserRatings;

/**
 * @author santoshpathak
 *
 */

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {
	
	@GetMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId){
		
		return new Rating(movieId, 4);
	}
	
	@GetMapping("/users/{userId}")
	public UserRatings getUsersRatings(@PathVariable("userId") String userId) {
		
		UserRatings userRatings = new UserRatings();
		userRatings.initData(userId);
		
		return userRatings;
	}

}
