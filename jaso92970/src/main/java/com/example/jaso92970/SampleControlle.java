package com.example.jaso92970;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample")
public class SampleControlle {
    @Autowired
    private SampleService Service;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("sampleForm", new SampleForm());
        return "index";
    }

    @PostMapping()
    public String search(@ModelAttribute SampleForm sampleForm, Model model) {
        model.addAttribute("list", Service.searchForm(sampleForm));
        return "sample";
    }
}
