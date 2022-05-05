package com.example.jaso88655;

import com.example.demo.service.TestService;
import javax.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
//    @Qualifier("serviceUserImpl")
    private TestService testService;

    @GetMapping
    public String index() {
        return "OK";
    }
}
