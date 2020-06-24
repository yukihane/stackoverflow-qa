package com.example.en62542331;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @Data
    public static class MyResource {
        private String text;
    }

    private MyResource createResource() {
        final MyResource res = new MyResource();
        res.setText("Hello, world!");
        return res;
    }

    @GetMapping("/json")
    @ResponseBody
    public MyResource idexJson() {
        return createResource();
    }

    @GetMapping("/jsp")
    public String input(final Model model) {
        final MyResource res = createResource();
        model.addAttribute(res);
        return "index";
    }

}