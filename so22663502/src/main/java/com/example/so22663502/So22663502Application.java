package com.example.so22663502;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class So22663502Application {

    public static void main(final String[] args) {
        SpringApplication.run(So22663502Application.class, args);
    }

    private final SomeEntityRepository repository;

    @GetMapping
    public List<SomeClass> index() {
        return repository.method();
    }
}
