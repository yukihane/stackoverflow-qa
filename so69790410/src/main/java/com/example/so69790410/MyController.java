package com.example.so69790410;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final EmployessServise service;

    @GetMapping
    public List<Employees_DTO> index() {
        return service.getAll_Emp();
    }
}
