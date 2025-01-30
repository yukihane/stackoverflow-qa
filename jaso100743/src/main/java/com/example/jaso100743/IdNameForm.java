package com.example.jaso100743;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class IdNameForm extends IdForm {
    private String name;
}
