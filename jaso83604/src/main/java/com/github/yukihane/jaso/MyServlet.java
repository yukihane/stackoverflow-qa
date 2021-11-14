package com.github.yukihane.jaso;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@WebServlet("/")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
        throws ServletException, IOException {

        final FormModel formModel = new FormModel("C:\\Users\\yuki\\Pictures\\jpg-format.jpg");
        //        final FormModel formModel = new FormModel("https://www.google.com");
        req.setAttribute("formmodel", formModel);

        final String view = "/WEB-INF/view/index.jsp";
        final RequestDispatcher dispatcher = req.getRequestDispatcher(view);

        dispatcher.forward(req, resp);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FormModel {
        private String url;
    }
}
