package com.example.so70184882;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyRepository repository;

    @GetMapping
    public List<MyEntity> index() {

        final String name = null;
        final List<MyEntity> res = repository.getDetails(name); // I am getting a NULL POINTER exception here. Why is this happening?

        return res;
    }
}
