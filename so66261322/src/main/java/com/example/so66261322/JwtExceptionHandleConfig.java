package com.example.so66261322;

import javax.servlet.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@Order(1)
public class JwtExceptionHandleConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        final Filter exceptionHandlerFilter = new ExceptionHandlerFilter();

        http.antMatcher("/jwtRequestFilter/exceptionHandlerFilter/**")
            .addFilterBefore(exceptionHandlerFilter, FilterSecurityInterceptor.class);
    }

}
