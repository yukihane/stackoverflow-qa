package com.example.so67308;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyRepository repository;

    @GetMapping("/")
    @Transactional
    public String method() {

        final MyEntity e = new MyEntity(1L, "new");
        final MyEntity p = repository.save(e);
        p.setName("renamed");
        repository.save(p);

        throw new RuntimeException(); // rollback
    }
}
