package com.example.so67716;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @see org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration
 * @see org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2WebSecurityConfiguration
 */
@Configuration
@RequiredArgsConstructor
public class MyOAuth2WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyLogoutHandler logoutHandler;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        http.oauth2Login(Customizer.withDefaults());
        http.oauth2Client();
        http.logout().addLogoutHandler(logoutHandler);
    }
}
