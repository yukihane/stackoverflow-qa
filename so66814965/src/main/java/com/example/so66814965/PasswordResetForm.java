package com.example.so66814965;

import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@FieldsValueMatch(field = "password", fieldMatch = "confirmPassword", message = "Passwords do not match")
public class PasswordResetForm {
    @Size(min = 8, message = "Password needs to have at least 8 characters")
    private String password;
    private String confirmPassword;
}
