package com.example.jaso71926;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

//    // デフォルトマッピング
//    @GetMapping
//    @RequestMapping(value = "/**")
//    @ResponseBody
//    String another(HttpServletRequest request) {
//        return "<HTML>Forbidden</HTML>";
//    }

    // ターゲットリクエストマッピング
    @GetMapping
    @RequestMapping(value = "/*")
    void index(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String uri = request.getRequestURI();
        if (uri.equals("/")) {

            // 実際にはこの地点で認証などの共通処理を実施

            response.getWriter().write(
                " <HTML>" +
                "   <HEAD>" +
                "     <TITLE>Sample-Page</TITLE>" +
                "   </HEAD>" +
                "   <BODY>" +
                "     <H1>Sample-Page</H1>" +
                "     <script src=\"./js/sample.js\"></script>" +
                "   </BODY>" +
                " </HTML>");

        } else {
            response.getWriter().write("<HTML>Forbidden</HTML>");
        }
    }
}
