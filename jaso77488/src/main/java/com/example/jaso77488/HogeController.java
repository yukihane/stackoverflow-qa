package com.example.jaso77488;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hoge")
@Slf4j
public class HogeController {

    @GetMapping
    String index() {
        log.info("Called hoge");
        return "hoge";
    }
}
