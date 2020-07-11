package com.github.yukihane.so.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TagOpenCloseValidator implements ConstraintValidator<TagOpenClose, String> {

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        // デフォルトのメッセージを抑制する
        context.disableDefaultConstraintViolation();
        return isValidOpen(value, context) & isValidClose(value, context);
    }

    // 開始タグの検証
    private boolean isValidOpen(final String value, final ConstraintValidatorContext context) {
        final boolean ret = value.contains("<mytag>");
        if (!ret) {
            context.buildConstraintViolationWithTemplate("開始タグがありません").addConstraintViolation();
        }
        return ret;
    }

    // 終了タグの検証
    private boolean isValidClose(final String value, final ConstraintValidatorContext context) {
        final boolean ret = value.contains("</mytag>");
        if (!ret) {
            // プロパティファイルからメッセージテンプレートを読む場合
            context.buildConstraintViolationWithTemplate("{com.github.yukihane.so.validation.TagOpenClose.noclose}")
                .addConstraintViolation();
        }
        return ret;
    }
}
