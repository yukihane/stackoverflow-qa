package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//テストで直接動かしたいクラス
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private SubMainService subMainService;

    @Override
    public String mainSayHello() {
        return "MainSayHello. Also..." + subMainService.subSayHello();
    }
}