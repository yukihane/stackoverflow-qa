package com.github.yukihane.examples;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class CompanyTest {

    @Test
    void test() {
        Human human = new Human();
        Company company = new Company(human);
        assertNull(company.getName());
    }

}
