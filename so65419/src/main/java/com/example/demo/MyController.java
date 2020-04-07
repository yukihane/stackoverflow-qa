package com.example.demo;

import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping(path = "/api/example")
    public String param(@RequestParam(name = "param", required = false) List<String> param) {
        if (param == null) {
            param = Collections.emptyList();
        }
        return param.toString();
    }

}
