package com.example.en62678102;

import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "germany.berlin")
public class AddressConfig {

    private Map<Integer, String> zipCode;

    public String getAreaForzipCode(final int code) {
        return zipCode.get(code);
    }

}
