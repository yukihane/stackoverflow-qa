package com.github.yukihane.so;

import com.github.yukihane.so.validation.TagOpenClose;
import lombok.Data;

@Data
public class Car {

    @TagOpenClose
    private String text;
}