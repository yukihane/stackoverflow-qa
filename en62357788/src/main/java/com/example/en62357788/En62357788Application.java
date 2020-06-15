package com.example.en62357788;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class En62357788Application implements CommandLineRunner {

    private final ExternalContext externalContext;
    
    public static void main(final String[] args) {
        SpringApplication.run(En62357788Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        System.out.println(externalContext.getEmailPassword());
        System.exit(0);
    }

}
