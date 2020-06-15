package com.example.en62357788;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${email.username}")
    private String emailUsername;

    @Value("${email.password}")
    private String password;

    private final PasswordDecryptor passwordDecryptor;

    public AppConfig(PasswordDecryptor passwordDecryptor) {
        this.passwordDecryptor = passwordDecryptor;
    }

    @Bean
    public String emailPassword(){
        return passwordDecryptor.decrypt(password);
    }

    @Bean(initMethod = "init" )
    public ExternalContext externalContext(){
        return new ExternalContext();
    }
}
