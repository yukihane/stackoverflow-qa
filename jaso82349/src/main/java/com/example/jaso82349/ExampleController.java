package com.example.jaso82349;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExampleController {
    @GetMapping("/")
    public String init() {

        // ...処理...

        return "example.html";
    }

    @PostMapping(value = "/", params = "ex1")
    public String postEx1(ExampleForm form) {

        // ...処理...

        return "example.html";
    }

    @PostMapping(value = "/", params = "ex2")
    public String postEx2(ExampleForm form) {

        // ...処理...

        return "example.html";
    }
}
