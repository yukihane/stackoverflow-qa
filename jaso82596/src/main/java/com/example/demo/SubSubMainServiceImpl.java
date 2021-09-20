package com.example.demo;

import org.springframework.stereotype.Service;

//SubMainServiceImplが依存しているクラス
@Service
public class SubSubMainServiceImpl implements SubSubMainService {

    @Override
    public String subSubSayHello() {
        return "SubSubSayHello";
    }
}
