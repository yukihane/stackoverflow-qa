package com.github.yukihane.so.messagespropertiesexample;

import java.util.Locale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {

    private final MessageSource messageSource;

    @Data
    @RequiredArgsConstructor
    @AllArgsConstructor
    public static class Result{
        private String message;
    }

    @GetMapping
    public Result get() {
        final String message = messageSource.getMessage("greeting", new Object[0], Locale.JAPAN);
        return new Result(message);
    }
}
