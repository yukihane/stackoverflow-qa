package com.example.validatingforminput;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(final PersonForm personForm) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid final PersonForm personForm, final BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
}
