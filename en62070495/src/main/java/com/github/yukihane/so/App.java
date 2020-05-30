package com.github.yukihane.so;

import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;

/**
 * Hello world!
 */
public class App {
   

    public static TaskDTO converTaskToDTO(Task source) {
        final ModelMapper modelMapper = new ModelMapper();
        
        List<Double> icList = new ArrayList<>();
        for (ChargeInitial c : source.getCharge()) {
            icList.add(c.getCharge());
        }
        System.out.println(icList);
        TypeMap<Task, TaskDTO> typeMap = modelMapper.getTypeMap(Task.class, TaskDTO.class);
        if (typeMap == null) {

            PropertyMap<Task, TaskDTO> mapping = new PropertyMap<Task, TaskDTO>() {
                @Override
                protected void configure() {
                    map().setLot(source.getLot().getName());
                    map().setProject(source.getLot().getProject().getName());
                    map().setCollaborator(source.getCollaborator().getEmail());
                    map().setCharge(icList);
                }
            };
            modelMapper.addMappings(mapping);
        }

        return modelMapper.map(source, TaskDTO.class);

    }
}
