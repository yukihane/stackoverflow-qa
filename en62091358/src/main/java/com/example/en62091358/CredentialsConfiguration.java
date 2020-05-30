package com.example.en62091358;

import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Validated
public class CredentialsConfiguration {

    @Bean
    public Credentials credentials(
        @NotBlank @Value("${app.username}") final String user_name,
        @NotBlank @Value("${app.password}") final String password) {

        return new Credentials(user_name, password);

    }
}
