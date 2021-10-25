package com.example.demo.mysql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

  @Autowired //別のクラスを使えるようにしてくれるもの
  EmployeeRepository empRepository;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index(Model model) {
    List<Employee> emplist = empRepository.findAll();
    model.addAttribute("employeelist", emplist);
    return "index";
  }

  @GetMapping("/search")
  public ModelAndView search(@RequestParam String NAME, ModelAndView mav) {
    List<Employee> list = empRepository.findByNAMELike("%" + NAME + "%");
    mav.addObject("list", list);
    mav.setViewName("/search");
    return mav;
  }
}
