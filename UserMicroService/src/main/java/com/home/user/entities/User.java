package com.home.user.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "micro_user")
public class User {
	
	@Id
	private String userId;
	
	private String name;
	
	private String email;
	
	private String about;
	
	@Transient
	private List<Rating> ratings = new ArrayList<>();
}
