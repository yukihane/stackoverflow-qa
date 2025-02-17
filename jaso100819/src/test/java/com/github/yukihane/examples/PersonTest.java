package com.github.yukihane.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

public class PersonTest {

    @Test
    public void testApp() {
        var p = new Person("Alice", 20);
        assertEquals("Alice", p.getName());
        assertEquals(20, p.getAge());
    }
}
