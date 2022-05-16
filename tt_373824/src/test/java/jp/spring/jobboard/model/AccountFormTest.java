package jp.spring.jobboard.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;

import javax.validation.ConstraintViolation;

import javax.validation.Validation;

import javax.validation.Validator;

import javax.validation.ValidatorFactory;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;
import org.junit.jupiter.api.BeforeEach;

//import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;

public class AccountFormTest {

    private Validator validator;

    @BeforeEach
    public void setUp() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

        validator = factory.getValidator();

    }

    @Test

    public void testValidationSuccess() {

        AccountForm form = new AccountForm();

        form.setUsername("user");

        form.setPassword("12345678");

        Set<ConstraintViolation<AccountForm>> violations = validator.validate(form);

        assertThat(violations.size()).isEqualTo(0);

    }

    @Test

    public void testValidationFailUsername() {

        AccountForm form = new AccountForm();

        form.setPassword("12345678");

        Set<ConstraintViolation<AccountForm>> violations = validator.validate(form);

        assertThat(violations.size()).isEqualTo(1);

        for (ConstraintViolation<AccountForm> violation : violations) {

            Object annotation = violation.getConstraintDescriptor().getAnnotation();

            assertThat(annotation).isInstanceOf(NotBlank.class);

        }

    }

    @Test
    public void testValidationFailPasswordBlank() {

        AccountForm form = new AccountForm();

        form.setUsername("user");

        Set<ConstraintViolation<AccountForm>> violations = validator.validate(form);

        assertThat(violations.size()).isEqualTo(1);

        for (ConstraintViolation<AccountForm> violation : violations) {

            Object annotation = violation.getConstraintDescriptor().getAnnotation();

            assertThat(annotation).isInstanceOf(NotBlank.class);

        }

    }

    @Test

    public void testValidationFailPasswordSize() {

        AccountForm form = new AccountForm();

        form.setUsername("user");

        form.setPassword("1234");

        Set<ConstraintViolation<AccountForm>> violations = validator.validate(form);

        assertThat(violations.size()).isEqualTo(1);

        for (ConstraintViolation<AccountForm> violation : violations) {

            Object annotation = violation.getConstraintDescriptor().getAnnotation();

            assertThat(annotation).isInstanceOf(Size.class);

        }

    }

}
