package com.home.user.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.home.user.entities.Rating;
import com.home.user.entities.User;
import com.home.user.exception.ResourceNotFoundException;
import com.home.user.external.services.HotelService;
import com.home.user.external.services.RatingService;
import com.home.user.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public User saveUser(User user) {
		//generated unique Id
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		userRepository.save(user);
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = userRepository.findAll();
		userList.stream().map(user ->{
			
			List<Rating> ratings = ratingService.getRating(user.getUserId());
			ratings.stream().map(rating -> {
				rating.setHotel(hotelService.getHotel(rating.getHotelId()));
				return rating;
			}).collect(Collectors.toList());
			
			user.setRatings(ratings);
			return user;
			
		}).collect(Collectors.toList());
		
		return userList;
		
	}

	@Override
	public User getUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> 
			new ResourceNotFoundException("User with given id is not found on server !! : "+userId));

//		Rating[] ratingArray = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		
		List<Rating> ratingList = ratingService.getRating(user.getUserId());
		
		List<Rating> ratings = ratingList.stream()
									.map(rating -> {
//										rating
//										.setHotel(restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(),Hotel.class));
//										
										rating.setHotel(hotelService.getHotel(rating.getHotelId()));
										return rating;
									})
									.collect(Collectors.toList());
				
		user.setRatings(ratings);
		return user;
	
	}

	@Override
	public User deleteUser(String userId) {
		User user = userRepository.findById(userId).orElseThrow(()-> 
		new ResourceNotFoundException("User with given id is not found on server !! : "+userId));
		userRepository.deleteById(userId);
		return user;
		
	}

	@Override
	public User updateUser(User user) {
		User updateUser = userRepository.findById(user.getUserId())
				.orElseThrow(()-> new ResourceNotFoundException("The user to update is not found on server !! "));
		updateUser.setAbout(user.getAbout());
		updateUser.setEmail(user.getEmail());
		userRepository.save(updateUser);
		return updateUser;
	}

}
