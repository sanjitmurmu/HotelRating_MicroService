package com.home.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserServiceConfigurations {
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(
//	  ServerHttpSecurity http) {
//	    return http.authorizeExchange()
//	      .pathMatchers("/actuator/**").permitAll()
//	      .anyExchange().authenticated()
//	      .and().build();
//	}

}
