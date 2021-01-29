package com.example.jaso73676;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {

    @GetMapping("text")
    public ResponseEntity<Resource> text() {
        final Resource res = new ClassPathResource("/hello.txt");
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("image")
    public ResponseEntity<Resource> image() {
        final Resource res = new ClassPathResource("/hana32px.png");
        return ResponseEntity.ok()
            .header("Content-Disposition", "attachment; filename=\"filename.jpg\"")
            .body(res);
    }
}
