package com.example.en62594348;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootConfiguration
@ComponentScan
//@SpringBootApplication
@RequiredArgsConstructor
public class En62594348Application implements CommandLineRunner {

    private final MyClass myClass;

    public static void main(final String[] args) {
        SpringApplication.run(En62594348Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        System.out.println(myClass.hello());
        System.exit(0);
    }

}
