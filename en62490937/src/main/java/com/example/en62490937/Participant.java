package com.example.en62490937;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Participant {

    @NotNull(message = "Participant must have name")
    @Pattern(regexp = ".+ .+")
    String fullName;
    private String dateOfBirth;
}
