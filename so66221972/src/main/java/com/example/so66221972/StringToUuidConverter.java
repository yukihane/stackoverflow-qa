package com.example.so66221972;

import java.util.UUID;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class StringToUuidConverter implements Converter<String, UUID> {
    @Override
    public UUID convert(@NonNull final String uuid) {
        return UUID.fromString(uuid);
    }
}
