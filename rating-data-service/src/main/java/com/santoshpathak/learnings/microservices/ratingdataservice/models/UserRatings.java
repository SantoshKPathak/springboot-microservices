/**
 * 
 */
package com.santoshpathak.learnings.microservices.ratingdataservice.models;

import java.util.Arrays;
import java.util.List;

/**
 * @author santoshpathak
 * This is just the top level wrapper class for List of ratings. Instead of returning Collection as topmost object from REST API
 * better to return an object as top level class.
 */
public class UserRatings {
	
	private String userId;
    private List<Rating> ratings;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public void initData(String userId) {
        this.setUserId(userId);
        
        this.setRatings(Arrays.asList(
                new Rating("100", 3),
                new Rating("200", 4)
        ));
    }
	
}
