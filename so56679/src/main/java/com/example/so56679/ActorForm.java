package com.example.so56679;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ActorForm {

    private String name;
    private String blood;
    private String height;
    //    @Pattern(regexp="(\\d{4}/\\d{2}/\\d{2})", message="{actor.validation.birthday}")
    @DateTimeFormat(pattern = "uuuu/MM/dd")
    private LocalDate birthday;
    private String birthplaceId;

}
