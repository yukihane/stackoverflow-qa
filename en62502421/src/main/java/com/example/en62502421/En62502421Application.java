package com.example.en62502421;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class En62502421Application implements CommandLineRunner {

    private final MyEntityRepository repository;

    public static void main(final String[] args) {
        SpringApplication.run(En62502421Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        repository.findById(1L);
        System.exit(0);
    }

}
