package com.example.so69858463;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

    private final RestTemplate restTemplate;

    public MyController(final RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @GetMapping
    public List<Map<String, ?>> index() throws URISyntaxException {
        final URI url = new URI("https://hccs-advancejava.s3.amazonaws.com/student_course.json");
        final ResponseEntity<List> resp = restTemplate.getForEntity(url, List.class);
        final List<Map<String, ?>> list = resp.getBody();
        return list;
    }
}
