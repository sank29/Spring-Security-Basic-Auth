package com.sanket.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {
	
	@Bean
	public InMemoryUserDetailsManager userDetailsManager(){
		
		UserDetails sanket = User.builder()
				
								.username("sanket")
								.password("{noop}12345")
								.roles("STUDENT")
								.build();
		
		
		UserDetails bachu = User.builder()
				
							.username("bachu")
							.password("{noop}12345")
							.roles("STUDENT")
							.build();
		
		UserDetails rushi = User.builder()
				
							.username("rushi")
							.password("{noop}12345")
							.roles("STUDENT")
							.build();
		
		UserDetails akash = User.builder()
				
							.username("akash")
							.password("{noop}12345")
							.roles("STUDENT", "TEACHER")
							.build();
		
		UserDetails admin = User.builder()
				
							.username("admin")
							.password("{noop}12345")
							.roles("STUDENT", "TEACHER", "ADMIN")
							.build();
		
		return new InMemoryUserDetailsManager(sanket, bachu, rushi, akash, admin);
		
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		
		http.authorizeHttpRequests(
				
				configuer ->{
					
					configuer
					
					.requestMatchers(HttpMethod.GET, "/api/student/**").hasRole("STUDENT")
					
					.requestMatchers(HttpMethod.POST, "/api/teacher/**").hasRole("TEACHER")
					.requestMatchers(HttpMethod.PUT, "/api/teacher/**").hasRole("TEACHER")
					
					.requestMatchers(HttpMethod.DELETE, "api/admin/**").hasRole("ADMIN");
				
					
					
				});
		
		
		http.httpBasic();
		
		http.csrf().disable();
		
		return http.build();
		
		
	}
	

	
	

}














