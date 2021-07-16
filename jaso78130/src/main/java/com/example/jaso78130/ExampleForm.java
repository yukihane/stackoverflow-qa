package com.example.jaso78130;

import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
public class ExampleForm {
    @NotNull(message = "searchName is Empty!!")
    private String searchName;

    // このフィールドのバリデーションメッセージを設定したい
    @DateTimeFormat(pattern = "yyyyMMddhhmmss")
    private Date searchDate;
}