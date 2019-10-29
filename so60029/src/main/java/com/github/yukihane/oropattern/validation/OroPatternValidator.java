package com.github.yukihane.oropattern.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.oro.text.regex.MalformedPatternException;
import org.apache.oro.text.regex.Pattern;
import org.apache.oro.text.regex.PatternMatcher;
import org.apache.oro.text.regex.Perl5Compiler;
import org.apache.oro.text.regex.Perl5Matcher;

public class OroPatternValidator implements ConstraintValidator<OroPattern, String> {

    private PatternMatcher matcher;
    private Pattern pattern;

    @Override
    public void initialize(final OroPattern constraintAnnotation) {
        matcher = new Perl5Matcher();
        try {
            this.pattern = new Perl5Compiler().compile(constraintAnnotation.value());
        } catch (final MalformedPatternException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext constraintContext) {
        return matcher.matches(value, pattern);
    }
}