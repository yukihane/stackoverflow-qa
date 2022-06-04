package com.example.tt_as57kse4hjcf70;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

    @Data
    public static class Form {
        @NotBlank(message = "名前を入力してください")
        public String inputName;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping
    public String post(@RequestParam(value = "input", required = false) final String input,
        @Validated final Form form,
        final BindingResult result, final Model model) {
        if (result.hasErrors()) {
            //エラーの場合の処理
            System.out.println(form);
            return "errorpage";
        } else {
            // 　　　//正常時の処理
            return "okpage";
        }
    }

}
