package com.example.en62502657;

import lombok.Data;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyComponent {

    private String username;

    public MyComponent(final DataSourceProperties prop) {
        this.username = prop.getUsername();
    }
}
