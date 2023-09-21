package com.home.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.hotel.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String>{

}
