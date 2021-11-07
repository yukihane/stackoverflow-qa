package com.example.so69856584;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final UserInfoRepository userInfoRepository;

    @GetMapping
    public List<UserInfo> index() {
        return userInfoRepository.getAll();
    }

}
