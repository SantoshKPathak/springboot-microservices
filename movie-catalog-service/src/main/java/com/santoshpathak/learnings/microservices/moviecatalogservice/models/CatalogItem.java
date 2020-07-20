/**
 * 
 */
package com.santoshpathak.learnings.microservices.moviecatalogservice.models;

/**
 * @author santoshpathak
 *
 */
public class CatalogItem {
	
	private String movieName;
	private String movieDesc;
	private int ratings;
	
	public CatalogItem(String movieName, String movieDesc, int ratings) {
		super();
		this.movieName = movieName;
		this.movieDesc = movieDesc;
		this.ratings = ratings;
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
	 * @return the movieDesc
	 */
	public String getMovieDesc() {
		return movieDesc;
	}

	/**
	 * @param movieDesc the movieDesc to set
	 */
	public void setMovieDesc(String movieDesc) {
		this.movieDesc = movieDesc;
	}

	/**
	 * @return the ratings
	 */
	public int getRatings() {
		return ratings;
	}

	/**
	 * @param ratings the ratings to set
	 */
	public void setRatings(int ratings) {
		this.ratings = ratings;
	}


//	@Override
//	public String toString() {
//		return "CatalogItem [movieName=" + movieName + ", movieDesc=" + movieDesc + ", ratings=" + ratings + "]";
//	}
	
	
	

}
