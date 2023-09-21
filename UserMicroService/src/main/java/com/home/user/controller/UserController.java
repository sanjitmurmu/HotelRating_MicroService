package com.home.user.controller;

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

import com.home.user.entities.User;
import com.home.user.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User user1 = userService.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
		
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
		
	}
	
	@PutMapping
	public ResponseEntity<User> updateUsers(@RequestBody User user){
		User updatedUser =  userService.updateUser(user);
		return ResponseEntity.ok(updatedUser);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable String userId){
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
		
	}
	
}
