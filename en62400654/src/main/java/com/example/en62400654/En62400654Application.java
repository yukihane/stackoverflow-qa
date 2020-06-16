package com.example.en62400654;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication
@Slf4j
public class En62400654Application implements CommandLineRunner {

    @Autowired
    PersonJbdcDao dao;

    public static void main(final String[] args) {
        SpringApplication.run(En62400654Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //      Thread.sleep(1000);  --------------------------------------------------> line 1
        log.info("All users -> {}", dao.findAll());
        System.exit(0);
    }

}
