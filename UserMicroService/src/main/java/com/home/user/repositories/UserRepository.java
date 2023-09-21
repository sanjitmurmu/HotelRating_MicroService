package com.home.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.user.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
}
