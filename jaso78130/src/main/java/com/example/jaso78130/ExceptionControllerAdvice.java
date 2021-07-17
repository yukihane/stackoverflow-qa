package com.example.jaso78130;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionControllerAdvice {

    private final MessageSource messageSource;

    @ExceptionHandler(BindException.class)
    public List<String> handleExampleBindException(final BindException bindEx) throws Exception {
        final List<String> list = new ArrayList<>();
        for (final FieldError err : bindEx.getBindingResult().getFieldErrors()) {
            list.add(messageSource.getMessage(err, LocaleContextHolder.getLocale()));
        }
        return list;
    }

}
