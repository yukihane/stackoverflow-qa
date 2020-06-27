package com.example.en62607140;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class VaultEngineApplication {

    public static void main(final String[] args) {
        SpringApplication.run(VaultEngineApplication.class, args);
    }

    @GetMapping("/h")
    public String greetingForm() {
        return "index";
    }
}