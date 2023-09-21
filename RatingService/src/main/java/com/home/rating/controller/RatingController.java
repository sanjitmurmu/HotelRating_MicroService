package com.home.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.rating.entities.Rating;
import com.home.rating.services.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(ratingService.create(rating));

	}
	
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		
		return ResponseEntity.ok(ratingService.getRatings());
	}
	
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
		
		return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
	}
	
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
		
		return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
	}
	

}
