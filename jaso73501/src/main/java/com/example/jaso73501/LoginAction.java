package com.example.jaso73501;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginAction {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }
}