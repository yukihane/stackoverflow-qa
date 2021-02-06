package com.example.so41570821;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SomeC {

    @Resource(name = "getP")
    private String p;

    @GetMapping
    public String index() {
        return p;
    }
}