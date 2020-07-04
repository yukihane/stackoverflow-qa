package com.example.en62727660;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class MyController {

    @GetMapping("")
    public String hello(final Model model) {
        model.addAttribute("name", "myname");
        return "hello";
    }
}
