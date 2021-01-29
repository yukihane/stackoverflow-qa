package com.example.jaso72939;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(final HttpServletRequest request,
        final HttpServletResponse response,
        final AuthenticationException authException) throws IOException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        final PrintWriter writer = response.getWriter();
        final JsonHolder holder = new JsonHolder();
        holder.setSuccess(false);
        holder.setData_size(0);
        holder.setData_list(Collections.emptyList());
        final Gson gson = new GsonBuilder().serializeNulls().create();
        final String json_data = gson.toJson(holder);
        writer.write(json_data);
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("Please Enter user and pass.");
        super.afterPropertiesSet();
    }
}
