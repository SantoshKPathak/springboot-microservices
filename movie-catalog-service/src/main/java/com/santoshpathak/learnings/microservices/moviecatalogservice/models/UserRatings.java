/**
 * 
 */
package com.santoshpathak.learnings.microservices.moviecatalogservice.models;

import java.util.List;

/**
 * @author santoshpathak
 * This is just the top level wrapper class for List of ratings. Instead of returning Collection as topmost object from REST API
 * better to return an object as top level class.
 */
public class UserRatings {
	
	private List<Rating> ratings;

	/**
	 * @return the ratings
	 */
	public List<Rating> getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	
	
}
