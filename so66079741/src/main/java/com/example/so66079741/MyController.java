package com.example.so66079741;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {

    private final MyService service;

    @GetMapping
    public String index() {
        return "index";
    }

    // Get /http://localhost:9091/getFeedback/138
    @GetMapping("/getFeedback/{id}")
    public Feedback getFeedback(@PathVariable final Integer id) {
        return service.getFeedback(id);
    }
}
