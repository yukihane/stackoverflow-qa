package com.github.yukihane.so;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class AppTest {

    public static final String TEXT = "[1,2]";

    @Test
    public void parseWithJackson() throws JsonMappingException, JsonProcessingException {
        final ObjectMapper mapper = new ObjectMapper();
        final int[] result = mapper.readValue(TEXT, int[].class);

        assertThat(result).isEqualTo(new int[] { 1, 2 });
    }

    @Test
    public void slitAsStream() {
        final Pattern p = Pattern.compile("\\D+");
        final int[] result = p.splitAsStream(TEXT)
            .filter(str -> !str.isEmpty())
            .mapToInt(Integer::parseInt).toArray();
        assertThat(result).isEqualTo(new int[] { 1, 2 });
    }
}
