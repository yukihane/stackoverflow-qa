package com.example.jaso78130;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(BindException.class)
    public List<String> handleExampleBindException(final BindException bindEx) throws Exception {
        final List<String> list = new ArrayList<>();
        for (final FieldError err : bindEx.getBindingResult().getFieldErrors()) {
            list.add(err.getDefaultMessage());
        }
        return list;
    }

}
