package com.example.jaso75599;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class MyController {

    @PostMapping("ajax.php")
    public Result index() {
        System.out.println("hello");
        return new Result(true);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {
        private boolean result;
    }
}
