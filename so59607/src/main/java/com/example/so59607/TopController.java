package com.example.so59607;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TopController {

    private final MyDataRepository repository;

    @GetMapping("/")
    public String top() {
        return "top";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView edit(@ModelAttribute MyData mydata, @PathVariable int id, ModelAndView mav) {
        mav.setViewName("edit");
        mav.addObject("title", "edit mydata");
        mav.addObject("id", id);
        Optional<MyData> data = repository.findById((long) id);
        mav.addObject("formModel", data.get());
        return mav;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    @Transactional(readOnly = false)
    public ModelAndView update(@ModelAttribute MyData mydata, @PathVariable int id, ModelAndView mav) {
        mydata.setId(id);
        repository.saveAndFlush(mydata);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/searchId", method = RequestMethod.GET)
    public ModelAndView searchId(@ModelAttribute("formModel") MyData mydata, ModelAndView mav) {
        mav.setViewName("searchId");
        return mav;
    }

    @RequestMapping(value = "/searchId", method = RequestMethod.POST)
    public ModelAndView serachId(@PathVariable int id, ModelAndView mav) {
        mav.setViewName("searchId");
        return new ModelAndView("'/edit");
    }
}
