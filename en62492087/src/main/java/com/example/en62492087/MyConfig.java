package com.example.en62492087;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyConfig {

    private final ProjectConverter projectConverter;

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper mapper = new ModelMapper();
        mapper.addMappings(projectConverter.getItemDTOMap());
        return mapper;
    }

}
