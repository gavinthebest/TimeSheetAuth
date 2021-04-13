package com.AuthServer;

import java.util.Arrays;

import com.AuthServer.model.User;
import com.AuthServer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SpringBootApplication
//public class AuthServerApplication implements CommandLineRunner {
public class AuthServerApplication {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		System.out.println("--------------------------------");
//		System.out.println("User found with getUser:");
//		User u = repository.findUsersByUsername("user2");
//		System.out.println(u);
//	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and().csrf().disable().authorizeRequests()
			.anyRequest().permitAll();
		}
	
		// solve the error: has been blocked by CORS policy
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowCredentials(true);
			configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers", "Access-Control-Allow-Origin",
					"Access-Control-Request-Method", "Access-Control-Request-Headers", "Origin", "Cache-Control",
					"Content-Type", "Authorization"));
			configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000","http://localhost:4200","http://localhost:4201"));
			configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE"));
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}

	}
}
