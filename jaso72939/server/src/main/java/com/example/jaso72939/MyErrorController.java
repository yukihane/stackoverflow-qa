package com.example.jaso72939;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class MyErrorController extends AbstractErrorController {

    public MyErrorController(final ErrorAttributes errorAttributes, final List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
    }

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping
    public ResponseEntity<Map<String, Object>> error(final HttpServletRequest request) {
        final HttpStatus status = getStatus(request);

        if (HttpStatus.UNAUTHORIZED.equals(status)) {
            final Map<String, Object> map = new HashMap<>();
            map.put("success", false);
            map.put("data_size", 0);
            map.put("data_list", Collections.emptyList());
            return new ResponseEntity<>(map, status);
        } else {
            return new ResponseEntity<>(status);
        }
    }
}
