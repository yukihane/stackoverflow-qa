package com.example.so70028145;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class So70028145Application {

    public static void main(final String[] args) {
        SpringApplication.run(So70028145Application.class, args);
    }

    @GetMapping
    public String index() {
        final User user = new User();
        user.setAge(10);
        validateUser(user);
        return "hello";
    }

    public void validateUser(final User user) {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        final Validator validator = factory.getValidator();
        final Set<ConstraintViolation<User>> violations = validator.validate(user);
    }
}
