package com.example.so66054392;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MyConfig {
    @Configuration
    public static class Conig1 {

        @Bean("Example.A")
        public ClassA getNewBean() {
            return new ClassA();
        }
    }

    @Configuration
    public static class Config2 {

        @Bean("Example.B")
        public ClassA getNewBean() {
            return new ClassA();
        }
    }

}
