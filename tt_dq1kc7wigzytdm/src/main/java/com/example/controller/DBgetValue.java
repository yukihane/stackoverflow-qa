package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

@Controller
public class DBgetValue {
    /**
     * ユーザー情報 Service
     */
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    /**
     * ユーザー情報一覧画面を表示
     *
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping(value = "/user/list")
    public String displayList(final Model model) {
        final List<User> userlist = userService.searchAll();//userServiceクラスのメソッドを呼び出している
        model.addAttribute("userlist", userlist);//サービスクラスから取得した内容を設定している
        return "user/list";//表示する画面を設定している（model.addAttributeで画面に渡す情報を指定してこの画面を表示する）
    }

    @GetMapping
    @ResponseBody
    public String index() {
        final User user1 = new User();
        user1.setNAME("name1");

        final User user2 = new User();
        user2.setNAME("name2");

        userRepository.save(user1);
        userRepository.save(user2);

        return "ok";
    }

}