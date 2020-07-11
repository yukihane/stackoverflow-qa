package com.github.yukihane.so.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = TagOpenCloseValidator.class)
@Documented
@Repeatable(TagOpenClose.List.class)
public @interface TagOpenClose {

    // disableDefaultConstraintViolation() により
    // デフォルトConstraintViolation生成は抑制されるため
    // 結果的にこのメッセージは利用されない
    String message() default "タグ検証エラー";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        TagOpenClose[] value();
    }
}
