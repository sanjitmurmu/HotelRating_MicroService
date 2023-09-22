package com.home.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.home.user.entities.Rating;
import com.home.user.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	void createRating() {
//		Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("built using feing client").build();
//		ratingService.createRating(rating);
//		
//		System.out.println("new rating created !!");
//	}

}
