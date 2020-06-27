package com.example.en62502657;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

@SpringBootApplication
@RequiredArgsConstructor
public class En62502657Application implements CommandLineRunner {

    private final MyComponent component;

    public static void main(final String[] args) {
        SpringApplication.run(En62502657Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        System.out.println("USERNAME: " + component.getUsername());
        System.exit(0);
    }

}
