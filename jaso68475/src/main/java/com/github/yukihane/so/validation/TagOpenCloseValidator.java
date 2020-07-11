package com.github.yukihane.so.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TagOpenCloseValidator implements ConstraintValidator<TagOpenClose, String> {

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        return false;
    }

}
