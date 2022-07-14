package com.example.validatingforminput;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PersonForm {

    @NotEmpty
    private String name;

    @NotNull
    @Min(18)
    private Integer age;
}
