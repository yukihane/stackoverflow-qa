package com.example.so66080463;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestStringsHolder {

    private String[] testStrings;

    public String[] getTestStrings() {
        return testStrings;
    }

    public void setTestStrings(String[] testStrings) {
        this.testStrings = testStrings;
    }
}
