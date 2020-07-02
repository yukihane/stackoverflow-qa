package com.example.en62681517;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    @PostMapping("/comments")
    public String comment(@RequestBody @Valid final Comment comment) {
        return comment.toString();
    }
}
