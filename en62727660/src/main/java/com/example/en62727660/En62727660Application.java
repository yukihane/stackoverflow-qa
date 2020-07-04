package com.example.en62727660;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication //(exclude = { ErrorMvcAutoConfiguration.class })
public class En62727660Application {

	public static void main(final String[] args) {
		SpringApplication.run(En62727660Application.class, args);
	}

}
