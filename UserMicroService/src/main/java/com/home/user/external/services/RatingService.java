package com.home.user.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.home.user.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
	
	//get all ratings based on userID
	@GetMapping("/ratings/users/{userId}")
	public List<Rating> getRating(@PathVariable String userId);
	
	
	//create rating	
	@PostMapping("/ratings")
	public Rating createRating(Rating rating);
	
	//update rating
	@PutMapping("/ratings/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId,Rating rating);
	
	//delete rating
	@DeleteMapping("/ratings/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
	

}
