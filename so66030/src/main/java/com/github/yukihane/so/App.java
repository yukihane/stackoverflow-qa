package com.github.yukihane.so;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class App {

    public static void main(final String[] args) throws JsonParseException, JsonMappingException, IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final File json = Paths.get("input.json").toFile();
        final TestDto test = mapper.readValue(json, TestDto.class);

        System.out.println(test);
    }
}

