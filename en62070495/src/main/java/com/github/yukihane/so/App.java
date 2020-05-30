package com.github.yukihane.so;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

/**
 * Hello world!
 */
public class App {
    static final ModelMapper modelMapper = new ModelMapper();

    public static TaskDTO converTaskToDTO(Task source) {

        TypeMap<Task, TaskDTO> typeMap = modelMapper.getTypeMap(Task.class, TaskDTO.class);
        if (typeMap == null) {

            PropertyMap<Task, TaskDTO> mapping = new PropertyMap<Task, TaskDTO>() {
                @Override
                protected void configure() {
                    map().setLot(source.getLot().getName());
                    map().setProject(source.getLot().getProject().getName());
                    map().setCollaborator(source.getCollaborator().getEmail());
                }
            };
            modelMapper.addMappings(mapping);

            Converter<List<ChargeInitial>, List<Double>> chargeInitialConverter = new AbstractConverter<>() {
                @Override
                protected List<Double> convert(List<ChargeInitial> source) {
                    List<Double> icList = new ArrayList<>();
                    for (ChargeInitial c : source) {
                        icList.add(c.getCharge());
                    }
                    System.out.println(icList);
                    return icList;
                }
            };
            modelMapper.addConverter(chargeInitialConverter);

        }

        return modelMapper.map(source, TaskDTO.class);

    }
}
