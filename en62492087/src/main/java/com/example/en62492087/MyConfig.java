package com.example.en62492087;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyConfig {

    @Bean
    public ModelMapper modelMapper() {
        final Converter<List<Location>, List<Long>> locationConverter = ctx -> ctx.getSource().stream()
            .map(Location::getId).collect(Collectors.toList());

        final ModelMapper mapper = new ModelMapper();
        mapper.typeMap(Project.class, ProjectDTO.class)
            .addMappings(m -> {
                m.using(locationConverter).map(Project::getLocations, ProjectDTO::setAssignedLocations);
            });
        return mapper;
    }

}
