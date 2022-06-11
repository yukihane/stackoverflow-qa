package com.example.so72580024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class So72580024Application {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

	public static void main(final String[] args) {
		SpringApplication.run(So72580024Application.class, args);
	}

}
