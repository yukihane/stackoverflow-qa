package com.example.jaso94800;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FileController {

    @GetMapping
    String index(Model model) {
        return "/index";
    }

    @PostMapping("/testDownload")
    void download(HttpServletResponse response) {
        URL name = Thread.currentThread().getContextClassLoader().getResource("");

        InputStream file = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("static/PNG.png");

        response.setContentType("image/png");
        response.setHeader("Content-Disposition"
                , "attachment; filename=\"" + "PNG.png" + "\"");

        try(OutputStream out = response.getOutputStream()) {

            byte[] downloadData = file.readAllBytes();
            out.write(downloadData);
            out.write(downloadData, 0, downloadData.length);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
