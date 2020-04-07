package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @InitBinder
    protected void initBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(String[].class, new StringArrayPropertyEditor(",", false, false));
    }

    @GetMapping(path = "/api/example")
    public String param(@RequestParam(name = "param", required = false) final String[] paramArray) {
        final List<String> param;
        if (paramArray == null) {
            param = Collections.emptyList();
        } else {
            param = Arrays.asList(paramArray);
        }
        return param.toString();
    }
}
