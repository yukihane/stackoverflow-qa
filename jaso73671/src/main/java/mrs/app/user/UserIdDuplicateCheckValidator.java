package mrs.app.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import mrs.domain.model.User;
import mrs.domain.service.user.UserService;


public class UserIdDuplicateCheckValidator
        implements ConstraintValidator<UserIdDuplicateCheck, User> {

    private String message;

    @Autowired
    UserService userService; // ★★ここが@Autowiredしてもnullになる★★

    @Override
    public void initialize(UserIdDuplicateCheck constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(User value, ConstraintValidatorContext context) {
        String userId = value.getUserId();
        Boolean blResult = userService.checkDuplicate(userId);

        if(!blResult) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(message).addPropertyNode("userId").addConstraintViolation();
        }

        return true;
    }
}
