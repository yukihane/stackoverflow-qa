package com.example.so66079741;

import org.springframework.stereotype.Service;

@Service
public class MyService {

    public Feedback getFeedback(final Integer id) {
        return new Feedback(id);
    }

}
