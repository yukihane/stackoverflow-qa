package com.example.so57857;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    @RequestMapping(value = "/profile/save", method = RequestMethod.GET)
    public String S161formList(Model model) {

        model.addAttribute("S100601formList", new S161formList());
        return "S161.html";
    }

    @RequestMapping(value = "/profile/save", method = RequestMethod.POST)
    public String form(@ModelAttribute S161formList S100601formList, Model model1) {
        int id = S100601formList.getId();
        int password = S100601formList.getPassword();

        System.out.println(id);
        System.out.println(password);
        return "S161.html";
    }

    public static class S161formList {

        private int id;
        private int password;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPassword() {
            return password;
        }

        public void setPassword(int password) {
            this.password = password;
        }
    }
}
