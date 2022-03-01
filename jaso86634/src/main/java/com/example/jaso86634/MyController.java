package com.example.jaso86634;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final SampleService service;


    @PostMapping("/item/create")
    public String create(final ItemInfo itemInfoParam,
        final Optional<ItemDetail> itemDetailParam,
        final HttpHeaders headers) {

        val itemDetail = itemDetailParam.orElseThrow(() -> new BadRequestException());
        service.create(itemInfoParam, itemDetail);

        return "OK";
    }

}
