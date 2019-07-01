package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloSpringBootWebController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(final ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public ModelAndView send(@RequestParam("inputvalue") final String inputvalue, final ModelAndView mv) {
        mv.setViewName("result");
        mv.addObject("message", inputvalue);
        return mv;
    }
}