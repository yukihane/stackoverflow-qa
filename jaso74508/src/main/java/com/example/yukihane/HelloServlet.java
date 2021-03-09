package com.example.yukihane;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {
        final String value = System.getProperty("foo");
        System.out.println(value);

        final InputStream res = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.txt");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(res));
        final String line = reader.readLine();
        System.out.println(line);

        resp.setStatus(HttpServletResponse.SC_CREATED);
    }

}
