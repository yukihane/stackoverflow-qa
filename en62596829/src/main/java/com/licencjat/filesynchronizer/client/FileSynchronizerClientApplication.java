package com.licencjat.filesynchronizer.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FileSynchronizerClientApplication {

    public static void main(final String[] args) {
        SpringApplication.run(FileSynchronizerClientApplication.class, args);
    }

}
