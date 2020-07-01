package com.example.en62677118;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String index() {
        final CreateFranchiseUseCase useCase = context.getBean(CreateFranchiseUseCase.class);
        return useCase.getText();
    }
}
