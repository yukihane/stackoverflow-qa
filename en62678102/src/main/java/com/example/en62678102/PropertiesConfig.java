package com.example.en62678102;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PropertiesConfig {

    @Bean
    MyComponent myComponent(final AddressConfig config) {
        final String area = config.getAreaForzipCode(10245);
        return new MyComponent(area);
    }
}