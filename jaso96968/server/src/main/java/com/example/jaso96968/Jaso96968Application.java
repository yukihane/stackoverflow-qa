package com.example.jaso96968;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Jaso96968Application {

    public static void main(final String[] args) {
        SpringApplication.run(Jaso96968Application.class, args);
    }

    public record Response(String greeting) {
    }

    @GetMapping
    public Response index() {
        return new Response("hello!");
    }

}
