package com.example.jaso83428;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @GetMapping("create")
    String create(@ModelAttribute CreateForm customerForm) {
      return "create";
    }

    @PostMapping("create")
    String regist(@Validated @ModelAttribute CreateForm createForm,
        BindingResult result,
        Model model) {
      if(result.hasErrors()) {



        return create(createForm);
      }
        User user = new User();
        Userdetail userdetail = new Userdetail();
        BeanUtils.copyProperties(createForm, user);
        BeanUtils.copyProperties(createForm, userdetail);
        sevi.insert(user);
        sevi.insert2(userdetail);

  return "redirect:/create";

    }
}
