package com.example.so69901065;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BusinessService {

    public ResponseEntity<?> createBusiness(@Valid CreateBusinessRequest request, String token) {
        return ResponseEntity.ok("hello");
    }

}
