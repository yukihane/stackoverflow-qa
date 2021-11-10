package com.example.jaso83501;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final MyService myService;

    @GetMapping
    public String index() {
        final String ret = myService.methodOne("arg");
        log.info("ret is {}", ret);
        return ret;
    }
}
