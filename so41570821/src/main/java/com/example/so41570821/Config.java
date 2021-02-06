package com.example.so41570821;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private final String p = "Prop";

    @Bean
    public String getP() {
        return p;
    }
}