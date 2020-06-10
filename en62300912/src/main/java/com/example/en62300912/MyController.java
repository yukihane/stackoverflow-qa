package com.example.en62300912;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/foo")
    public String foo() {
        return "foo";
    }

    @GetMapping("/moo")
    public String moo() {
        return "moo";
    }

    @GetMapping("bar")
    public String bar() {
        return "bar";
    }
}
