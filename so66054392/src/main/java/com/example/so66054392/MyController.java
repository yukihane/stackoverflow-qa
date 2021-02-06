package com.example.so66054392;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    @Resource(name = "Example.A")
    private ClassA Example_A;

    @GetMapping
    public String index() {
        return "";
    }
}
