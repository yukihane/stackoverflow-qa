package com.example.en62681160;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class En62681160Application implements CommandLineRunner {

    private final RestTemplateBuilder builder;

	public static void main(final String[] args) {
		SpringApplication.run(En62681160Application.class, args);
	}

    @Override
    public void run(final String... args) throws Exception {

        final String uri = "http://localhost:8080/";
        final RestTemplate restTemplate = builder.build();
        final String plainCreds = "devTest:DevTest123";
        final byte[] plainCredsBytes = plainCreds.getBytes();
        final byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        final String base64Creds = new String(base64CredsBytes);
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        headers.setContentType(MediaType.APPLICATION_JSON);
        final HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        final ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        log.info("Result output is: " + response.getBody());

        System.exit(0);
    }

}
