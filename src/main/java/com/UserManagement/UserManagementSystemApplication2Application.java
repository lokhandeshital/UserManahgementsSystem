package com.UserManagement;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UserManagementSystemApplication2Application {

	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemApplication2Application.class, args);
		System.out.println("User Service is Up and Running");
	}

	@Bean
	ModelMapper model() {
		return new ModelMapper();

	}

}
