package com.example.en62094894;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyConfig.MyClass myClass;

    @GetMapping("/")
    public String get() {
        return "path: " + myClass.getPath();
    }
}
