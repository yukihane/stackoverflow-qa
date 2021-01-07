package com.example.so65611020;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyControllerAdvise extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyExcepton.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(final HttpServletRequest request, final Throwable ex) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
