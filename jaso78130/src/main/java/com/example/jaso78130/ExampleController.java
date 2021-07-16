package com.example.jaso78130;

import java.util.List;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping("/example/search")
    public List<String> searchExample(@Validated final ExampleForm form) throws Exception {

        // ... 処理 ...

        return List.of();
    }

}