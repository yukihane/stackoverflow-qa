package com.example.jaso94913.controller;

import com.example.jaso94913.model.Book;
import com.example.jaso94913.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BookController {

    @Autowired
    BookService service;

    @GetMapping("/book-list")
    public String bookList(final Model model) {

        // serviceを使って、本の一覧をDBから取得する
        final List<Book> bookList = service.findAll();
        // modelに本の一覧を設定して、画面に渡す
        model.addAttribute("bookList", bookList);
        // bookList.htmlの表示
        return "bookList";
    }
}