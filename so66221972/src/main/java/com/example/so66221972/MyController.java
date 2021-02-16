package com.example.so66221972;

import java.util.Map;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    @GetMapping("test")
    public Map<String, Object> index(final UUID uuid) {
        return Map.of("uuid", uuid.toString());
    }
}
