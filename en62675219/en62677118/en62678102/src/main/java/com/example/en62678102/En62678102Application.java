package com.example.en62678102;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class En62678102Application implements CommandLineRunner {

    private final MyComponent comp;

	public static void main(final String[] args) {
		SpringApplication.run(En62678102Application.class, args);
	}

    @Override
    public void run(final String... args) throws Exception {
        System.out.print(comp.getArea());
        System.exit(0);
    }

}
