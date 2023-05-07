package com.example.jaso94722;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private QuizRepository quizRepository;

    @GetMapping
    List<Quiz> index() {
        Iterable<Quiz> quizList = quizRepository.findAll();
        ArrayList<Quiz> result = new ArrayList<>();
        quizList.forEach(result::add);
        return result;
    }
}
