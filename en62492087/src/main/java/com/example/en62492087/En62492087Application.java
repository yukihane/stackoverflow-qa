package com.example.en62492087;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class En62492087Application implements CommandLineRunner {

    private final ModelMapper modelMapper;

    public static void main(final String[] args) {
        SpringApplication.run(En62492087Application.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        final Project source = new Project(List.of(new Location(1L, "hello")));
        final ProjectDTO dest = modelMapper.map(source, ProjectDTO.class);
        System.out.println(dest);

        System.exit(0);
    }

}
