package com.example.jaso83310;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

  @Autowired
  UserService sevi;

  @Autowired
  UserRepository rep;
  //初期画面
  @RequestMapping(value = "/", method = RequestMethod.GET)
  String login(@ModelAttribute UserForm form) {
    //List<User> list = sevi.findAll();
    //UserForm form1 = new UserForm();
    //model.addAttribute("form", new UserForm());
    //model.addAttribute("list", list);
    return "login";
  }
  //ログイン
  @PostMapping("yeah")
  public String Login(
      @RequestParam String id,
      @RequestParam String pass,
      @Validated @ModelAttribute UserForm form,
      BindingResult result,
      Model model
      ) {
    if (result.hasErrors()) {
      return login(form);
    }
    User u = sevi.Login(id, pass);
    if (null == sevi.Login(u.getId(), u.getPass())) {
      return "login";
    } else {
      return "search";
    }
  }
  //検索
  @PostMapping("search")
  public ModelAndView search(@RequestParam String name,
      ModelAndView mav) {
    List<User> list = sevi.findBynameLike(name);
    mav.addObject("list", list);
    mav.setViewName("/search");
    return mav;
  }
}
