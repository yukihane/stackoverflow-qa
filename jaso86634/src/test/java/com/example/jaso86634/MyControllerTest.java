package com.example.jaso86634;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class MyControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    SampleService service;

    @Test
    public void webTestClient() {
        when(service.create()).thenReturn("OK");

        webTestClient.post()
            .uri(uriBuilder -> uriBuilder
                .path("/item/create")
                .queryParam("id", 1L)
                .queryParam("name", "name1") // ここまでがItemInfo
                .queryParam("deid", 2L)
                .queryParam("type", "box") //　ここまでがItemDetail
                .build())
            .exchange()
            .expectStatus().isOk()
            .expectBody(String.class).isEqualTo("OK");
    }

}
