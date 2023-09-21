package com.home.hotel.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.hotel.entities.Hotel;
import com.home.hotel.exceptions.ResourceNotFoundException;
import com.home.hotel.repositories.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomId = UUID.randomUUID().toString();
		hotel.setId(randomId);
		return hotelRepository.save(hotel);
		
	}

	@Override
	public List<Hotel> getAllHotels() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotel(String id) {
		
		return hotelRepository.findById(id).orElseThrow(()->
			new ResourceNotFoundException("hotel with given id not found !! "+id));
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		Hotel updateHotel = hotelRepository.findById(hotel.getId()).orElseThrow(()->
		new ResourceNotFoundException("hotel to update is not found !! "));
		updateHotel.setAbout(hotel.getAbout());
		updateHotel.setLocation(hotel.getLocation());
		updateHotel.setName(hotel.getName());
		return hotelRepository.save(updateHotel);
	}

	@Override
	public Hotel deleteHotel(String id) {
		Hotel deletedHotel = hotelRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("hotel to be deleted is not found !! "));
		hotelRepository.delete(deletedHotel);
		return deletedHotel;
		
	}

}
