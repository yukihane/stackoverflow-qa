package com.example.en62681517;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MyController {

    private final CommentRepository repository;

    @PostMapping("/comments")
    public String comment(@RequestBody final Comment comment) {
        final Comment res = repository.save(comment);
        return res.toString();
    }
}
