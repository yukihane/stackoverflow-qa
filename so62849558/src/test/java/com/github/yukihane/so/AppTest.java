package com.github.yukihane.so;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class AppTest {

    private static String json;

    @BeforeAll
    public static void setUp() throws IOException {
        try (final BufferedReader r = new BufferedReader(
            new InputStreamReader(AppTest.class.getClassLoader().getResourceAsStream("testdata.txt")))) {
            json = r.lines().collect(Collectors.joining("\n")).toString();
        }
    }

    @Test
    public void testApp() throws JSONException {
        final String text = "{" + json;
        final JSONObject obj = new JSONObject(text);
        final String api = obj.getString("api");
        final JSONObject object2 = new JSONObject(api);
        final String first = object2.getJSONArray("predictions").getJSONObject(0).getString("teams");

        System.out.println(first);
    }
}
