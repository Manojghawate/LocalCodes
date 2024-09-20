//package com.restful.web.services.FirstApp.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
////@EnableWebSecurity
////@Configuration
//public class SpringSecurityConfiguration {
//	@Bean SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable();
//		http.authorizeRequests(auth -> auth.anyRequest().authenticated());
//		http.httpBasic();
//		
//		return http.build();
//	}
//}
