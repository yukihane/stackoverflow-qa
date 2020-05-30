package com.example.en62093967;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyEntityRepository repository;

    @GetMapping("/all")
    public String all() {
        final String res = repository.findAll().stream().map(MyEntity::toString).reduce("", String::concat);
        return res;
    }

    @GetMapping("/")
    public void useJpql() {
        final String currentTime = LocalDateTime.now().toString();

        repository.updateWithoutSelect(1L, currentTime);
    }
}
