package com.example.so62882225;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class MyConfiguration {

    @Bean
    @Lazy
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    MyBean myBean() {
        return new MyBean();
    }
}
