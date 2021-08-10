package com.example.jaso72892;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MyController {

    private final PersonRepository personRepository;

    @GetMapping
    public Optional<Person> index() {
        return personRepository.findById(new FullName("新渡戸", "稲造"));
    }
}
