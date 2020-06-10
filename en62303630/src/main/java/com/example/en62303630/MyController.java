package com.example.en62303630;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/")
    public String index() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        MyUser myUser = (MyUser) authentication.getPrincipal();
        return "Hello, " + myUser.getUsername() + "!";
    }
}
