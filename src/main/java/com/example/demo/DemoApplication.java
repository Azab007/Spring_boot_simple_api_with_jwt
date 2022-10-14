package com.example.demo;

import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null,"Admin"));
			userService.saveRole(new Role(null,"patient"));
			userService.saveRole(new Role(null,"doctor"));

			userService.saveUser(new User(null,"Azab","azab@gmail.com","1234","Mo Azab",new ArrayList<>()));
			userService.saveUser(new User(null,"Mariam","mariam@gmail.com","1255","Mariam Azab",new ArrayList<>()));

			userService.addRoleToUser("Mo Azab","Admin");
			userService.addRoleToUser("Mariam Azab","patient");
		};
	}
}
