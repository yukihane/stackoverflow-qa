package com.example.so65612634.service;

import com.example.so65612634.model.dto.DtoUsernamePassword;
import javax.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ServiceSign {

    public String createUser(String username, String password) {
        return "";
    }

    public String takeToken(@Valid DtoUsernamePassword dtoUsernamePassword) {
        return "";
    }

}
