package com.example.jaso77488;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/piyo")
@Slf4j
public class PiyoController {

    @GetMapping
    public String index() {
        log.info("Called piyo");
        new InnerClass().execute();
        return "piyo";
    }

    @Slf4j
    public static class InnerClass {
        public void execute() {
            log.info("InnerClass is executed");
        }
    }
}
