package com.example.en62502421;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class Beans {
    @Bean
    ThreadPoolTaskExecutor taskExecutor() {
        throw new NullPointerException();
    }
}
