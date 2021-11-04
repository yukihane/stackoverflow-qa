package com.example.so69812231;

import com.example.so69812231.validation.GreaterThan;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@GreaterThan(value = 100, message = "100")
public class So69812231Application {

    public static void main(final String[] args) {
        SpringApplication.run(So69812231Application.class, args);
    }

    @PostMapping
    public String index(@RequestBody @Validated final MyEntity entity) {
        return "OK";
    }

    @Data
    public static class MyEntity {
        @NotNull(message = "distance should not be empty")
        @GreaterThan(value = 0, message = "distance value should be above 0.")
        private Double distance;
    }
}
