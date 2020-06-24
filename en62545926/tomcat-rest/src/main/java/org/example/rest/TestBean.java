package org.example.rest;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TestBean {
    public String test() {
        return "Test Bean";
    }
}
