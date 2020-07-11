package com.github.yukihane.so;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyEntityTest {

    private static Validator validator;

    @BeforeAll
    public static void setUpValidator() {
        final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void nothing() {
        final MyEntity target = new MyEntity();
        target.setText("hello");
        final Set<ConstraintViolation<MyEntity>> res = validator.validate(target);

        assertThat(res.size()).isEqualTo(2);

        final Iterator<ConstraintViolation<MyEntity>> ite = res.iterator();
        final List<String> messages = new ArrayList<>();
        while (ite.hasNext()) {
            messages.add(ite.next().getMessage());
        }
        assertThat(messages).contains("開始タグがありません");
        assertThat(messages).contains("close tag is not found");
    }

    @Test
    public void openOnly() {
        final MyEntity target = new MyEntity();
        target.setText("<mytag>hello");
        final Set<ConstraintViolation<MyEntity>> res = validator.validate(target);
        assertThat(res.size()).isEqualTo(1);
        final Iterator<ConstraintViolation<MyEntity>> ite = res.iterator();
        assertThat(ite.next().getMessage()).isEqualTo("close tag is not found");
    }

    @Test
    public void valid() {
        final MyEntity target = new MyEntity();
        target.setText("<mytag>hello</mytag>");
        final Set<ConstraintViolation<MyEntity>> res = validator.validate(target);
        assertThat(res.size()).isEqualTo(0);
    }
}
