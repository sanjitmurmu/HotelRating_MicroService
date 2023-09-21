package com.home.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.hotel.entities.Hotel;
import com.home.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(hotelService.createHotel(hotel));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String hotelId){
		return ResponseEntity.ok(hotelService.getHotel(hotelId));
	}
	
	@PutMapping
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel){
		return ResponseEntity.ok(hotelService.updateHotel(hotel));
	}
	
	@DeleteMapping("/{hotelId}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable String hotelId){
		return ResponseEntity.ok(hotelService.deleteHotel(hotelId));
	}
	
	

}
