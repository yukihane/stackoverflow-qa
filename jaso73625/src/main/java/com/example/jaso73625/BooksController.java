package com.example.jaso73625;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BooksController {
    
    @Autowired
    private BooksRepository booksRepository;
    

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Books> books = booksRepository.findAll();
        model.addAttribute("booklist", books);
        return "books";
    }
}
