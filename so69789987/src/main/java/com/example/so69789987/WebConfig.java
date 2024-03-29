package com.example.so69789987;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//unnecessary in most cases
//https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#features.developing-web-applications.spring-mvc.auto-configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{

 @Override
 public void addCorsMappings(CorsRegistry registry) {
     registry.addMapping("/**")
             .allowedMethods("PUT", "DELETE","POST","GET")
             .allowedOrigins("*")
             .exposedHeaders("*");
 }
}
