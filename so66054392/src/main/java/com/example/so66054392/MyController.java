package com.example.so66054392;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    @Qualifier("Example.A")
    private ClassA obj;

    @GetMapping
    public String index() {
        return "";
    }
}
