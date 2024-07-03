package com.example.jaso99674;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/secure/{id}")
    ResponseEntity<Integer> secure(@PathVariable int id) {
        return ResponseEntity.ok(id);
    }
}
