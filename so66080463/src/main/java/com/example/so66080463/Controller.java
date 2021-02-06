package com.example.so66080463;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final TestService testService;
    private TestStringsHolder holder;

    @Autowired
    public Controller(TestService testService, TestStringsHolder holder) {
        this.testService = testService;
        this.holder = holder;
    }

    @PostMapping("test")
    public List<String> test(@RequestBody TestDTO request) {
        String[] testStrings = request.getTestStrings();
        holder.setTestStrings(testStrings);

        List<String> strings = testService.getStringsOverLength5();
        return strings;
    }
}
