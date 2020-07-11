package com.github.yukihane.so;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;



public class CarTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void tag() {
        final Car target = new Car();
        target.setText("hello");
        final Set<ConstraintViolation<Car>> res = validator.validate(target);
        assertThat(res.size()).isEqualTo(1);
        assertThat(res.iterator().next().getMessage()).isEqualTo("error");
    }
}
