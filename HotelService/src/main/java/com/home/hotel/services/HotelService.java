package com.home.hotel.services;

import java.util.List;

import com.home.hotel.entities.Hotel;

public interface HotelService {
	
	Hotel createHotel(Hotel hotel);
	
	List<Hotel> getAllHotels();
	
	Hotel getHotel(String id);
	
	Hotel updateHotel(Hotel hotel);
	
	Hotel deleteHotel(String id);

}
