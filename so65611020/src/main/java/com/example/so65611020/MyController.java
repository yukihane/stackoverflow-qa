package com.example.so65611020;

import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MyController {

    @GetMapping
    public String index() throws HttpRequestMethodNotSupportedException {
        throw new MyExcepton();
    }

}
