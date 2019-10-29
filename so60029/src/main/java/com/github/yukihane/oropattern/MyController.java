package com.github.yukihane.oropattern;

import com.github.yukihane.oropattern.validation.OroPattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Data
    public static class MyParam {
        // 2桁数字
        @OroPattern("\\d{2}")
        private String value;
    }

    @PostMapping("/")
    public MyParam post(@RequestBody @Validated final MyParam param) {
        return param;
    }
}
