package com.example.so65819;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Data
    @AllArgsConstructor
    public static class User {
        private long id;
        private String name;
        private int age;
        private String address;
    }

    @Data
    public static class ListForm {
        private long id;
        private String name;
        private int age;
        private String address;
        private long targetId;
    }

    private static final List<User> USERS = List.of(new User(1, "山田", 20,
        "大阪"),
        new User(2, "田中", 20, "大阪"),
        new User(3, "佐藤", 20, "大阪"),
        new User(4, "鈴木", 20, "大阪"));

    @GetMapping
    public ModelAndView get() {
        final Map<String, Object> model = Map.of("list", USERS, "listForm", new ListForm());
        return new ModelAndView("user", model);
    }

    @PostMapping
    public ModelAndView post(@ModelAttribute final ListForm listForm) {


        log.info("Received: {}", listForm);
        log.info("Target: {}", listForm.getTargetId());

        // 以下ダミーコード
        final Map<String, Object> model = Map.of("list", USERS, "listForm", new ListForm());
        return new ModelAndView("user", model);
    }
}
