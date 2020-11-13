package com.example.jaso71926;

import java.io.IOException;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

@Configuration
public class MyConfig {

    // https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-embedded-container-servlets-filters-listeners-beans
    @Bean
    FilterRegistrationBean<RefererCheckFilter> refererCheckFilter() {
        FilterRegistrationBean<RefererCheckFilter> registration = new FilterRegistrationBean<>(
            new RefererCheckFilter());
        registration.setUrlPatterns(List.of("/js/*"));
        registration.setName("refererCheckFilter");
        registration.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registration;
    }

    public static class RefererCheckFilter implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            String referer = req.getHeader(HttpHeaders.REFERER);
            if (!StringUtils.hasText(referer) || !referer.startsWith("http://localhost:8080")) {
                HttpServletResponse resp = (HttpServletResponse) response;
                // https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-error-handling-custom-error-pages
                // にある通りハンドルされる
                resp.sendError(HttpStatus.FORBIDDEN.value(), HttpStatus.FORBIDDEN.getReasonPhrase());
                return;
            }

            chain.doFilter(request, response);
        }
    }
}
