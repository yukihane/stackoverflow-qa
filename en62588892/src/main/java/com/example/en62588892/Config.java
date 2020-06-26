package com.example.en62588892;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")
    public someClass method(final someOtherClass obj) {
        return new someClass(obj.getText());
    }
}
