package com.example.so66080463;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final TestStringsHolder holder;

    public TestService(TestStringsHolder holder) {
        this.holder = holder;
    }

    public List<String> getStringsOverLength5() {
        final String[] testStrings = holder.getTestStrings();

        return Arrays.stream(testStrings)
            .filter(s -> s.length() > 5)
            .collect(Collectors.toList());
    }
}
