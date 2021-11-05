package com.example.jaso83436;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MyController {
    
    private final MyServiceImpl sevi;

    @PostMapping("double")
    String DoubleCheck(@RequestParam String id,
  Model model) {

      User u = sevi.doubleCheck(id);
      //model.addAttribute("u", u);
      if (null != u) {
          String msg = "重複してるよ";
          model.addAttribute("msg", msg);
          return "double";
      }
      String msg2 = "重複してないよ";
      model.addAttribute("msg2", msg2);
      return "double";
  }

}
