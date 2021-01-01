package com.example.jaso73000;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class MyPicAccessRestrictionFilter extends OncePerRequestFilter {

    private static final Map<String, String> ALLOW_LIST = Map.of(
        "/data/pic/pic1.jpg", "user1",
        "/data/pic/pic2.jpg", "user2",
        "/data/pic/pic3.jpg", "user3");

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
        final FilterChain filterChain)
        throws ServletException, IOException {

        final SecurityContext ctx = SecurityContextHolder.getContext();
        final Authentication authn = ctx.getAuthentication();
        if (authn == null) {
            response.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        final String name = authn.getName();

        final String path = request.getServletPath();
        final String allowedUser = ALLOW_LIST.get(path);

        if (!Objects.equals(name, allowedUser)) {
            response.sendError(HttpStatus.FORBIDDEN.value(), name + "には権限がありません");
            return;
        }

        filterChain.doFilter(request, response);
    }

}
