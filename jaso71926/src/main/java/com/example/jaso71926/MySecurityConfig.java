package com.example.jaso71926;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/*")
            .addFilterBefore(new FillHeaderFilter(), BasicAuthenticationFilter.class)
            .addFilterAt(new BasicAuthenticationFilter(authenticationManager(), new BasicAuthenticationEntryPoint()),
                BasicAuthenticationFilter.class);

        http
            .antMatcher("/**").authorizeRequests().anyRequest().authenticated();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("myuser").password("{noop}mypassword").roles("USER");
    }

    public static class FillHeaderFilter implements Filter {

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
            HttpServletRequest req = (HttpServletRequest) request;
            String header = req.getHeader(HttpHeaders.AUTHORIZATION);
            if (!StringUtils.hasText(header)) {
                HttpServletResponse resp = (HttpServletResponse) response;
                resp.addHeader("WWW-Authenticate", "Basic realm=\"example.com\"");
                resp.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
                return;

                //                req = new HttpServletRequestWrapper(req) {
                //                    public String getHeader(String name) {
                //                        if (HttpHeaders.AUTHORIZATION.equals(name)) {
                //                            return "Basic ";
                //                        }
                //                        return super.getHeader(name);
                //                    }
                //                };
            }

            chain.doFilter(req, response);
        }
    }
}
