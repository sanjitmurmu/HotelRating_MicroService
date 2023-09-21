package com.home.rating.services;

import java.util.List;

import com.home.rating.entities.Rating;

public interface RatingService {
	
	//create
	Rating create(Rating rating);
	
	//get all ratings
	List<Rating> getRatings();
	
	
	//get all by userId
	List<Rating> getRatingsByUserId(String userId);
	
	
	//get all by hotelId
	List<Rating> getRatingsByHotelId(String hotelId);

}
