package com.github.yukihane.so;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class CreateMosaicTest {

    @Test
    public void testApp() throws IOException {
        String pMosaic = Files.readAllLines(Paths.get("src/test/resources/testdata.json"))
            .stream()
            .collect(Collectors.joining());
        CreateMosaic obj = new CreateMosaic();
        obj.CreateMosaicArt(pMosaic);
    }
}
