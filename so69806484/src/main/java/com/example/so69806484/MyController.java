package com.example.so69806484;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    @GetMapping("/authenticate")
    public String authenticate() {
        return "authenticate";
    }

    @GetMapping("/secure")
    public String secure() {
        return "secure";
    }
}
