package com.example.so69898042;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class So69898042Application {

    public static void main(String[] args) {
        SpringApplication.run(So69898042Application.class, args);
    }

    private final CustomerEntityRepository repository;

    @GetMapping
    public List<CustomerEntity> index() {
        return repository.findOnlyNameAndPhoneFromCustomer();
    }
}
