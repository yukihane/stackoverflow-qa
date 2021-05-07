package com.github.yukihane;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;
import java.util.stream.StreamSupport;

public class App {

    public static void main(final String[] args) throws JsonParseException, MalformedURLException, IOException {
        final URL url = new URL("https://www3.nhk.or.jp/news/special/coronavirus/data/latest-pref-data.json");
        final ObjectMapper mapper = new ObjectMapper();

        final JsonNode tree = mapper.readTree(url);

        final JsonNode data47 = tree.get("data47");

        // 全県出力
        for (final JsonNode pref : data47) {
            System.out.println(pref.get("name") + ": " + pref.get("new"));
        }

        // 大阪府を抽出
        System.out.println();
        final int count = StreamSupport.stream(data47.spliterator(), false)
            .filter(e -> Objects.equals(e.get("name").asText(), "大阪府"))
            .findFirst()
            .map(e -> e.get("new").asInt())
            .get();

        System.out.println("大阪府: " + count);
    }
}
