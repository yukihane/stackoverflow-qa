package com.example.en62303630;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Init {

    private final ApplicationUserRepository repository;

    @PostConstruct
    @Transactional
    public void init() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        ApplicationUser user = new ApplicationUser();
        user.setUsername("user");
        user.setPassword(encoder.encode("password"));
        repository.save(user);
    }
}
