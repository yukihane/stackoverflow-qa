package com.example.en62482467;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class En62482467Application implements CommandLineRunner {

    private final PersonService personService;

    public static void main(final String[] args) {
        SpringApplication.run(En62482467Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        final Person ret = personService.getPerson();
        System.out.println(ret.getText());
        System.exit(0);
    }

}
