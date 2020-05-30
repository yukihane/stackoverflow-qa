package com.example.en62097557;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FunctionController {
    @RequestMapping("/function/hash")
    public String hashPage(final Model m) {
        return "html/hashcode.html";
    }
}
