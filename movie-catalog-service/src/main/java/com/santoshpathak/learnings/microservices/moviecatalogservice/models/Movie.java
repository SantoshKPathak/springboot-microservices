/**
 * 
 */
package com.santoshpathak.learnings.microservices.moviecatalogservice.models;

/**
 * @author santoshpathak
 *
 */
public class Movie {
	private String movieId;
	private String movieName;
	private String movieOverview;
	
	public Movie() {}
	
	public Movie(String movieId, String movieName, String movieOverview) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieOverview = movieOverview;
	}

	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the movieName
	 */
	public String getMovieName() {
		return movieName;
	}

	/**
	 * @param movieName the movieName to set
	 */
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	/**
	 * @return the movieOverview
	 */
	public String getMovieOverview() {
		return movieOverview;
	}

	/**
	 * @param movieOverview the movieOverview to set
	 */
	public void setMovieOverview(String movieOverview) {
		this.movieOverview = movieOverview;
	}
	
	
	
}
