package com.example.jaso73000;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class MySecurityConfig {

    // サンプルユーザ作成
    // https://docs.spring.io/spring-security/site/docs/current/reference/html5/#servlet-authentication-inmemory
    @Bean
    UserDetailsService userDetailsService() {
        final UserBuilder builder = User.withDefaultPasswordEncoder();
        final List<UserDetails> users = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            final UserDetails user = builder
                .username("user" + i)
                .password("user" + i)
                .roles("USER")
                .build();
            users.add(user);
        }
        return new InMemoryUserDetailsManager(users);
    }
}
