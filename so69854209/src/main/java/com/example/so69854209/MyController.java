package com.example.so69854209;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final ArticleRepository articleRepository;

    @GetMapping
    public ArticleDTO index() {
        final Optional<ArticleDTO> res = articleRepository.getArticle(1L);
        return res.orElse(null);
        //        return "hello";
    }
}
