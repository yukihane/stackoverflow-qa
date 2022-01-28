package to.msn.wings.selfjsp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PokemonServlet")
public class PokemonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Object hello = "hello";
        // printPatternSwitch(hello);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
        out.println("<title>スクリプトレット</title>");
        out.println("</head><body>");
        for (int i = 0; i < 5; i++) {
            out.println("こんにちは、世界！<br>");
        }
        out.println("</body></html>");

    }

    static void printPatternSwitch(Object o) {
        switch (o) {
            case null:
                System.out.println("*null*");
                break;
            case Integer i:
                System.out.printf("int %d%n", i);
                break;
            case Long l:
                System.out.printf("long %d%n", l);
                break;
            case Double d:
                System.out.printf("double %f%n", d);
                break;
            case String s:
                System.out.printf("String %s%n", s);
                break;
            default:
                System.out.println(o);
                break;
        }
        ;
    }

}
