package com.example.so69789987;

import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//https://docs.spring.io/spring-security/site/docs/5.4.2/reference/html5/#cors
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

 @Override
 protected void configure(final HttpSecurity http) throws Exception {
     // if disabling CSRF protection
     // https://docs.spring.io/spring-security/site/docs/5.5.3/reference/html5/#csrf-when
     http.csrf().disable();

     // if Spring MVC is on classpath and no CorsConfigurationSource is provided,
     // Spring Security will use CORS configuration provided to Spring MVC
     http.cors(Customizer.withDefaults());
 }
}
