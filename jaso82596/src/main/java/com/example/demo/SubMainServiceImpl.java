package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//MainServiceImplが依存しているクラス
@Service
public class SubMainServiceImpl implements SubMainService {

    @Autowired
    private SubSubMainService subSubMainService;

    @Override
    public String subSayHello() {
        return "SubSayHello. Also..." + subSubMainService.subSubSayHello();
}
}