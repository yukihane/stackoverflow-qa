package com.example.en62681160;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MyController {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private List<Result> result;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Result {
        private String number;
        private String sysCreatedOn;
        private String name;
        private String businessId;
        private String routineId;
    }

    @GetMapping("/")
    public Response index() {
        final List<Result> results = List.of(new Result("number", "sysCreatedOn", "name", "businessId", "routineId"));
        return new Response(results);
    }
}
