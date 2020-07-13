package com.example.so62882225;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {

    @Autowired
    private MyBean myBean;

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        System.out.println("Log");
        return myBean.greet();
    }

}