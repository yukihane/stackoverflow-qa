package com.example.en62396625;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class post {

    //@Autowired
    visitorrepository visitorrepository;

    @PostMapping("/post")
    public void insert(@Valid @RequestBody newvisitor newvisitor) {

    }

}
