package com.example.so66080463;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final TestService testService;

    @Autowired
    public Controller(TestService testService) {
        this.testService = testService;
    }

    @PostMapping("test")
    public List<String> test(@RequestBody TestDTO request) {
        String[] testStrings = request.getTestStrings();

        // I want to run testService.getStringsOverLength5() on testStrings

        List<String> strings = testService.getStringsOverLength5();
        return strings;
    }
}