package com.example.en62492087;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Service;

@Service
@Getter
@RequiredArgsConstructor
public class ProjectConverter {

    public Converter<List<Location>, List<Long>> locationToLongConverter = new Converter<>() {

        @Override
        public List<Long> convert(final MappingContext<List<Location>, List<Long>> context) {
            final List<Location> source = context.getSource();
            final List<Long> destination = context.getDestination();

            for (final Location location : source) {
                destination.add(location.getId());
            }

            return destination;
        }

    };

    PropertyMap<Project, ProjectDTO> itemDTOMap = new PropertyMap<>() {

        @Override
        protected void configure() {
            using(locationToLongConverter).map(source.getLocations()).setAssignedLocations(null);
        }
    };

}