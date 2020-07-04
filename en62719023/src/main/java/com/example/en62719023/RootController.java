package com.example.en62719023;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

    @CrossOrigin
    @GetMapping("/")
    public String index() {
        return "Hello from server";
    }
}