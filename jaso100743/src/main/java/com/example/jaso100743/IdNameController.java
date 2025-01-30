package com.example.jaso100743;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class IdNameController {
    @RequestMapping("/idname")
    public String index(final Model model) {
        model.addAttribute("idNameForm", new IdNameForm());
        return "IdName";
    }

    @PostMapping("/idNamePost")
    public String post(
            @Validated @ModelAttribute final IdNameForm form,
            final BindingResult result) {
        if (result.hasErrors()) {
            result.rejectValue("name", "error.name", "未登録です。");
            return "IdName";
        }
        form.setName("Hello, " + form.getId() + "!");
        return "IdName";
    }
}
