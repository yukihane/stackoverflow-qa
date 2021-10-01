package com.example.demo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    @GetMapping
    public List<NewData> index() {
        return List.of(new NewData("foo"), new NewData("bar"), new NewData("baz"));
    }

    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class NewData {
        private String name;
    }
}
