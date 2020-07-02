package com.example.en62681517;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final CommentRepository repository;

    @PostMapping("/comments")
    public String comment(@RequestBody final Comment comment) {
        log.info("comment: {}", comment);
        final Comment res = repository.save(comment);
        return res.toString();
    }
}
