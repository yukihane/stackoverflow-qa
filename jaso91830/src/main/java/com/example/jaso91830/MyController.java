package com.example.jaso91830;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final MyDataRepository myDataRepository;
    private final JdbcTemplate jdbcTemplate;
    private final AtomicInteger count = new AtomicInteger();

    @GetMapping
    public String index() {
        final var data = new MyData();
        data.setName("name" + count.getAndIncrement());
        myDataRepository.save(data);

        jdbcTemplate.queryForList("SELECT * FROM my_data WHERE name=?", "testName");

        return "ok";
    }

}
