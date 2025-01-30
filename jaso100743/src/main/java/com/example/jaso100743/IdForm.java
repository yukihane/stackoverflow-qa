package com.example.jaso100743;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class IdForm {
    @Pattern(regexp = "^[0-9a-zA-Z]{8}$")
    private String id;
}
