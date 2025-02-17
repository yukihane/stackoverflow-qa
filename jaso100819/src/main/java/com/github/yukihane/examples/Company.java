package com.github.yukihane.examples;

public class Company {
    private Human human;
    public Company(Human human) {
        this.human = human;
    }
    public String getName() {
        return human.getName();
    }
}
