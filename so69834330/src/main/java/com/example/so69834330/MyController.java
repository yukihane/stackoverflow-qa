package com.example.so69834330;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {
    
    private final MyService myService;

    @GetMapping
    public String index() {
        myService.addNewCourse();
        return "hello";
    }
}
