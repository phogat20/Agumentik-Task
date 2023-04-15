package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// <---------------------- For Authorization ----------------->
	// For Authorization we use HttpSecurity class.
	// TO go from more restrictive to less restrictive URL role.

	@Bean
	SecurityFilterChain deafaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()

// 	<---------------------- CORs(Cross origin resource sharing) ----------------->
//				.cors().configurationSource(new CorsConfigurationSource() {
//
//					@Override
//					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
//						CorsConfiguration config = new CorsConfiguration();
//						config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//						config.setAllowedMethods(Collections.singletonList("*"));
//						config.setAllowCredentials(true);
//						config.setAllowedHeaders(Collections.singletonList("*"));
//						config.setMaxAge(3600L);
//
//						return config;
//					}
//				}).and()

				.authorizeHttpRequests()

//	<----------------------------- for ROLE based Authorization ------------------->
//				The ROLE_ prefix is automatically added. so we should not start with ROLE_.

				.requestMatchers("/admin").hasRole("ADMIN").requestMatchers("/user").hasRole("USER")

				.requestMatchers("/contact", "/register").permitAll().and().formLogin().and().httpBasic();

		return http.build();
	}

//	<------------------------- Password encoder ------------------------------->
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
