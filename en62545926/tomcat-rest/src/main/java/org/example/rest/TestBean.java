package org.example.rest;

import javax.ejb.Stateless;

@Stateless
public class TestBean {
    public String test() {
        return "Test Bean";
    }
}
