package com.example.jaso78113;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MyController {

    @RequestMapping(value = "/", consumes = "text/plain")
    public String index(@RequestBody final String body) {
        System.out.print(body);
        return body;
    }
}
