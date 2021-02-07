package com.example.so66079741;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {

    private final MyService service;

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/getFeedback")
    @ResponseBody
    public Feedback getFeedback(@RequestParam("name") final Integer id) {
        return service.getFeedback(id);
    }

    //    // Get /http://localhost:9091/getFeedback/138
    //    @GetMapping("/getFeedback/{id}")
    //    public Feedback getFeedback(@PathVariable Integer id) {
    //        return service.getFeedback(id);
    //    }
}
