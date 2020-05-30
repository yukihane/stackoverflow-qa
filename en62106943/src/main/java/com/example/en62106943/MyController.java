package com.example.en62106943;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final AccountRepository repository;

    @GetMapping("/insert")
    public String insert() {
        Account a = new Account();
        a.setAccountNumber("number1");
        repository.save(a);
        return "success";
    }

    @GetMapping("/")
    public String get() {
//        List<Account> ret = repository.findAll();
//        return "" + ret.size();
                Account ret = repository.findByAccountNumber("number1");
                return (ret==null) ? "null": ret.toString();
    }
}
