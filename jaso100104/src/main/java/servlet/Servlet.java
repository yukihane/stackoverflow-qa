package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import lexer.LexerJava;

@WebServlet(urlPatterns={"/Servlet"})
public class Servlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }

    protected void doPost(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String inputBox = request.getParameter("inputBox");
        String calculation = request.getParameter("calculation");

        LexerJava lexer = new LexerJava();
        String tokenizedResult = "";
        try {
            tokenizedResult = lexer.init(calculation).tokenizeToString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        out.println(inputBox);
        out.println(calculation);
        out.println(tokenizedResult);
        out.println("a");

        request.setAttribute("inputBox", inputBox);
        request.setAttribute("calculation", calculation);
        request.setAttribute("tokenizedResult", tokenizedResult);

        request.getRequestDispatcher("/servletResult.jsp").forward(request, response);
    }
}
