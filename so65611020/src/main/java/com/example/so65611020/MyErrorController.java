package com.example.so65611020;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MyErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public MyErrorController(final ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(final HttpServletRequest request) {
        final WebRequest webRequest = new ServletWebRequest(request);
        final Throwable th = errorAttributes.getError(webRequest);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
