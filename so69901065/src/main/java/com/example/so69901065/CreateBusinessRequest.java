package com.example.so69901065;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBusinessRequest {
    @NotNull
    private String name;

    @Valid
    private List<Address> addresses;
}
