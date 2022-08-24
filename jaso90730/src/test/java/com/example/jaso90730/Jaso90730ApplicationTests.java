package com.example.jaso90730;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class Jaso90730ApplicationTests {

    @Autowired
    @Qualifier("mysqlJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
        final List<Map<String, Object>> ret = jdbcTemplate.queryForList("select * from greeting_table");
        ret.forEach(System.out::println);
	}

}
