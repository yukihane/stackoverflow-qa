package com.example.en62724909;

import java.util.Date;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class ToDo {

    public String getDescription() {
        return "description";
    }

    public Date getTargetDate() {
        return new Date();
    }

}
