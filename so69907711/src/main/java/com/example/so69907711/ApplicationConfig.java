package com.example.so69907711;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "props")
@Data
@Component
public class ApplicationConfig {
    private Map<String, List<ServiceMetadata>> markets = new HashMap<>();

    @Data
    public static class ServiceMetadata {

        private String applicationName;
        private String backendURL;
    }

}

