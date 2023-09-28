package com.home.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		
		http
			.authorizeExchange((exchange) -> exchange
					.anyExchange()
					.authenticated()
					)
			.oauth2Client(Customizer.withDefaults())
			.oauth2ResourceServer((oauth2ResourceServer) -> oauth2ResourceServer
					.jwt(Customizer.withDefaults()));
	
		return http.build();
			  
	}

}
