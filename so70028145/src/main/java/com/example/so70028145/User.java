package com.example.so70028145;

import javax.validation.constraints.Min;
import lombok.Data;

@Data
public class User {
    @Min(value = 3)
    private int age;
}
