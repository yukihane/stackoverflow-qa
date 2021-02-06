package com.example.so41570821;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SomeC {

    private String p;

    public SomeC(@Qualifier("p") String p) {
        this.p = p;
    }

    @GetMapping
    public String index() {
        return p;
    }
}