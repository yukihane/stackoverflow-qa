package com.example.en62635356;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class En62635356ApplicationTests {

    @Autowired(required = false)
    private CondClass clazz;

	@Test
	void contextLoads() {
        assertNotNull(clazz);
	}

}
