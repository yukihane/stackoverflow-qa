package com.example.so66080463;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final String[] testStrings;

    public TestService(String[] testStrings) {
        this.testStrings = testStrings;
    }

    public List<String> getStringsOverLength5() {
        return Arrays.stream(testStrings)
            .filter(s -> s.length() > 5)
            .collect(Collectors.toList());
    }
}
