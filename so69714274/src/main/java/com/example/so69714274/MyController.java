package com.example.so69714274;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyEntityRepository repository;

    @GetMapping
    public List<MyEntity> index() {
        final List<MyEntity> res = repository.filterByName(List.of("a", "b"));
        return res;
    }

    @GetMapping("/insert")
    public String insert() {
        final MyEntity e1 = new MyEntity();
        e1.setName("a");
        e1.setAge(1);
        repository.save(e1);

        final MyEntity e2 = new MyEntity();
        e2.setName("b");
        e2.setAge(2);
        repository.save(e2);

        final MyEntity e3 = new MyEntity();
        e3.setName("c");
        e3.setAge(3);
        repository.save(e3);

        return "ok";
    }
}
