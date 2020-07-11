package com.example.so62853927;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class MyController {
    @GetMapping(value = "students", params = { "name" })
    public ResponseEntity<?> getByName(@RequestParam final String name) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping(value = "students", params = { "tag" })
    public ResponseEntity<?> getByTag(@RequestParam final String tag) {
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
