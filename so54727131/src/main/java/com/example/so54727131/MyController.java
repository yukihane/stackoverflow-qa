package com.example.so54727131;

import java.util.Map;
import javax.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    @Resource(name = "clasAText")
    private String text;

    @Autowired
    @Qualifier("clsB")
    private String text2;

    @GetMapping
    public Map<String, String> index() {
        return Map.of("by name", text, "by qualifier", text2);
    }

}
