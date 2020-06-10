package com.github.yukihane.springsecurityauthexample.rest;

import com.github.yukihane.springsecurityauthexample.entity.User;
import com.github.yukihane.springsecurityauthexample.repository.UserRepository;
import java.security.Principal;
import java.util.concurrent.atomic.AtomicInteger;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private static final AtomicInteger NUMBER = new AtomicInteger(1);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    @Transactional
    public String register() {
        final int num = NUMBER.getAndIncrement();
        final User user = new User("user" + num, "password" + num);
        userRepository.save(user);

        return "Created: " + user;
    }

    @GetMapping("/hello")
    public String hello(@AuthenticationPrincipal final Principal principal) {
        return "Hello, " + principal.getName() + "!";
    }
}
