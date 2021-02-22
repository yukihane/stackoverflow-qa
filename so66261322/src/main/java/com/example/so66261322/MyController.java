package com.example.so66261322;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/jwtRequestFilter/*")
    public String index() {
        return "OK";
    }
}
