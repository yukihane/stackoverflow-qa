package com.example.jaso83501;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    @Override
    public String methodOne(final String arg) {
        return "methodOne executed";
    }
}
