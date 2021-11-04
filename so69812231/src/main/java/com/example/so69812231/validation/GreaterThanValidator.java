package com.example.so69812231.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GreaterThanValidator implements ConstraintValidator<GreaterThan, Double> {

    private double range;

    @Override
    public void initialize(final GreaterThan constraintAnnotation) {
        this.range = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(final Double value, final ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return value.doubleValue() > this.range;
    }

}
