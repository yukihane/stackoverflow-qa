package com.example.so66814965;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResetPasswordController {

    @ModelAttribute("passwordResetForm")
    public PasswordResetForm passwordResetForm() {
        return new PasswordResetForm();
    }

    @GetMapping("/reset-password")
    public String showResetPasswordForm(final Model model) {
        return "reset-password";
    }

    @PostMapping("/reset-password-result")
    public String resetPassword(@Valid final PasswordResetForm passwordResetForm, final Model model,
        final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reset-password";
        }
        // reset password logic
        return "redirect:/reset-password-success";
    }
}
