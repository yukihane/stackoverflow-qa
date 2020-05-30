package com.example.en62098435;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String hello() {
        return "Hello, world!";
    }
}
