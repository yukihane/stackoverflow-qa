package com.example.so69907711;

import com.example.so69907711.ApplicationConfig.ServiceMetadata;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class So69907711Application {

    public static void main(final String[] args) {
        SpringApplication.run(So69907711Application.class, args);
    }

    private final ApplicationConfig config;

    @GetMapping
    public Map<String, List<ServiceMetadata>> index() {
        return config.getMarkets();
    }
}
