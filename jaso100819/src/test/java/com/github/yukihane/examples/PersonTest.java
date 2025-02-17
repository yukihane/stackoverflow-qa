package com.github.yukihane.examples;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;

public class PersonTest {

    @Test
    public void testApp() {
        var p = new Person("Alice", 20);
        assertThat(p.getName()).isEqualTo("Alice");
        assertThat(p.getAge()).isEqualTo(20);
    }
}
