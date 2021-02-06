package com.example.so54727131;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClsA {

    @Bean
    @Qualifier("ClasA")
    public String getSomething() {
        return "somethingA";
    }
}
