package com.example.demo;

import com.example.demo.models.Item;
import com.example.demo.repositries.InquiryRepository;
import com.example.demo.repositries.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {

    @Autowired
    InquiryRepository repository;
    @Autowired
    ItemRepository itemRepository;

/***** 略 *****/

    @GetMapping("/item/create")
    public String itemCreate(Item itemForm, Model model) {
        model.addAttribute("itemForm", itemForm);
        return "root/item/create";
    }

    @PostMapping("/item/create")
    public String itemCreate(@Validated Item itemForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "root/item/create";
        }

        // RDBと連携できることを確認しておきます。
        itemRepository.saveAndFlush(itemForm);
        itemForm.clear();
        model.addAttribute("message", "アイテムを登録しました。");
        return "root/item/create";
    }
}
