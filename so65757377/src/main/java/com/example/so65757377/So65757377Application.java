package com.example.so65757377;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class So65757377Application {

	public static void main(final String[] args) {
		SpringApplication.run(So65757377Application.class, args);
	}

}
