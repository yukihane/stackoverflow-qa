package com.example.so69744898;

import org.springframework.stereotype.Component;

@Component
public class MyDependencyImpl implements MyDependency{

    @Override
    public Integer execute(String param) {
        throw new UnsupportedOperationException();
    }

}
