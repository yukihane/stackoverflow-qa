package com.example.so69905016;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class So69905016Application {

    public static void main(String[] args) {
        SpringApplication.run(So69905016Application.class, args);
    }

    @GetMapping("/status/SwCheckStatus")
    public List<MyData> index() {
        MyData d1 = new MyData("", 1, "Area 1", "Regular 1");
        MyData d2 = new MyData("", 1, "Area 1", "Regular 2");
        MyData d3 = new MyData("", 1, "Area 1", "Spring Boot 1");
        MyData d4 = new MyData("", 1, "Area 1", "Spring Boot 2");
        return List.of(d1, d2, d3, d4);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class MyData {
        private String instanceName;
        private int read;
        private String swProduct;
        private String swProductModule;
    }
}
