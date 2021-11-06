package com.example.jaso83449;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MyController {
    @PostMapping("search")
    public String index(
        @RequestParam String id,
        @RequestParam String name,
        @RequestParam String kana,
        @ModelAttribute CreateForm createForm,
        @Validated @ModelAttribute SearchForm searchForm,
        BindingResult result,
        Model model,
        HttpServletRequest request) {
      List<Userdetail> search = equipmentRepository.find(id, name, kana);
      BeanUtils.copyProperties(createForm, search);
      HttpSession session = request.getSession();
      session.setAttribute("search", search);
      model.addAttribute("search", search);
      if (result.hasErrors()) {
        return "search";
      }
      return "searchout";
    }

  @PostMapping(path = "update", params = "update")
    String update(@RequestParam String id, @ModelAttribute CreateForm createForm) {
      Optional<User> opt = sevi.selectById(id);
      User u = opt.get();
      BeanUtils.copyProperties(u, createForm);
      return "update";
    }

    @PostMapping(path = "update", params = "back")
    String back() {
      return "redirect:/";
    }

    @PostMapping(path = "update", params = "regist")
    //ポイント2
    String regist(@RequestParam String id, @Validated @ModelAttribute CreateForm createForm, BindingResult result,Model model) {
        if (result.hasErrors()) {
            return update(id, createForm);
        }
        User user = new User();
        //Userdetail userdetail = new Userdetail();
        BeanUtils.copyProperties(createForm, user);
       // BeanUtils.copyProperties(createForm, userdetail);
        sevi.update(user);
        //sevi.updatee(userdetail);
      model.addAttribute("searchForm", new SearchForm());
        return "search";
    }

}
