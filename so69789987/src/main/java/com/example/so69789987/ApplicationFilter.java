package com.example.so69789987;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ApplicationFilter implements Filter {
//    @Autowired
//    private UserDetails userDetails;
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        
        String token = httpRequest.getHeader("Authorization").substring(7);
        
        Jws<Claims> jwsParsed = null;
        try {
             jwsParsed = Jwts.parserBuilder()
                    .setSigningKey("Yn2kjibddFAWtnPJ2AFlL8WXmohJMCvigQggaEypa5E=".getBytes())
                    .build()
                    .parseClaimsJws(token);

        } catch (Exception e) {
//            throw new AuthenticationException("The token is not correct.");
            throw new BadCredentialsException("The token is not correct.");
        }

        Long id = jwsParsed.getBody().get("id", Long.class);
        String name = jwsParsed.getBody().get("name", String.class);
        
//        userDetails.setUserId(id);
//        userDetails.setUserName(name);
        
        chain.doFilter(httpRequest, response);
    }
}