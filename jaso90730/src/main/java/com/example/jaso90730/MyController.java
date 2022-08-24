package com.example.jaso90730;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<Map<String, Object>> index() {
        final List<Map<String, Object>> ret = jdbcTemplate.queryForList("select * from greeting_table");
        return ret;
    }
}
