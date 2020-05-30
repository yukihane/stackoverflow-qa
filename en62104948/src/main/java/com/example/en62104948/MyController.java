package com.example.en62104948;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final VideoService videoService;

    @GetMapping("/test")
    public ObjectId test(@RequestBody final OIdLGroupIds OIdLGroupIds, @RequestParam final ObjectId _id) {
        return videoService.test();
    }
}
