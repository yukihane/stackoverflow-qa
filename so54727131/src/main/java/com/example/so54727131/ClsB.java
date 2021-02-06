package com.example.so54727131;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClsB {

    @Bean("clsBText")
    @Qualifier("clsB")
    public String getSomething() {
        return "somethingB";
    }
}
