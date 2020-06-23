package com.example.en62542331;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    @RequestMapping(path = "/", method = { RequestMethod.GET })
    public String input(final Model model) {

        return "index";
    }
}