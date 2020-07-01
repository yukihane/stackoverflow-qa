package com.example.en62675219;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class En62675219Application implements CommandLineRunner {

    //    String kafkarwsrproxyURL = String.format("%s/topics/%s", "https://kafka-rest-proxy-**********",
    //        "test-topic");
    //    String schemaurl = String.format("%s/subjects/%s/versions/latest", "https://schema-registry-*********",
    //        "test-topic");

    String kafkarwsrproxyURL = "http://localhost:8080/kafka";
    String schemaurl = "http://localhost:8080/schema";

    @Autowired
    private RestTemplate restTemplate;

    public static void main(final String[] args) {
        SpringApplication.run(En62675219Application.class, args);
    }

    @Data
    public static class Req {
        private String text;
    }

    @PostMapping("/kafka")
    public String kafka(@RequestBody final Req req) {
        return req.getText();
    }

    @Override
    public void run(final String... args) throws Exception {

        final JSONObject event = new JSONObject();
        event.put("text", "hello");

        final HttpHeaders messageheaders = new HttpHeaders();
        messageheaders.setContentType(MediaType.valueOf("application/vnd.kafka.avro.v2+json"));
        messageheaders.setBasicAuth("username", "password");
        final HttpEntity<JSONObject> message = new HttpEntity<>(event, messageheaders);

        final ResponseEntity<String> result1 = restTemplate.exchange(kafkarwsrproxyURL, HttpMethod.POST,
            message, String.class);

        if (result1.getStatusCodeValue() == 200) {
            System.out.println("Message is pushed to Kafka");
        }

        System.exit(0);
    }
}
