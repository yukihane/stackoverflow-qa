package com.example.en62094894;

import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@Validated
public class MyConfig {

    @Data
    @RequiredArgsConstructor
    public static class MyClass {
        private final String path;
    }

    @Bean
    MyClass createSslContext(
        @Value("#{systemProperties['javax.net.ssl.trustStore']}")
        @NotBlank(message = "Truststore is needed") final
        String path) {

        return new MyClass(path);
    }

}
