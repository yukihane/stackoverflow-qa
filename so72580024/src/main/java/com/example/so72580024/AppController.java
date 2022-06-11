package com.example.so72580024;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(method = RequestMethod.GET, produces = { "application/json; charset=utf-8" })
@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class AppController {

    @Autowired
    private RestTemplate restTemplate;

    private static String url = "https://imdb-api.com/en/API/Top250Movies/k_1kz039kt";

    @GetMapping("/top250movies")
    public List<MovieModel> getTop250Movies() {
        final Response top250movies = restTemplate.getForObject(url, Response.class);
        System.out.println(top250movies.getItems().size());
        return top250movies.getItems();
    }
}
