package com.example.en62357788;

import javax.naming.NamingException;
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
    public ExternalContext externalContext() throws NamingException {
        ExternalContext ctx = new ExternalContext();
        ctx.setEmailUsername(emailUsername);
        ctx.setEmailPassword(passwordDecryptor.decrypt(password));
        ctx.init();
        return ctx;
    }
}
