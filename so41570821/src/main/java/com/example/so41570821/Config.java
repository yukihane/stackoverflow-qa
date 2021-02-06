package com.example.so41570821;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    private final String p = "Prop";
    private final String q = "AnotherProp";

    @Bean
    @Qualifier("p")
    public String getP() {
        return p;
    }

    @Bean
    @Qualifier("q")
    public String getQ() {
        return q;
    }
}