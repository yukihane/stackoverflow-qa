package com.example.en62482467;

public interface PersonService {
    default Person getPerson() {
        return new Person(getClass().getName());
    }
}
