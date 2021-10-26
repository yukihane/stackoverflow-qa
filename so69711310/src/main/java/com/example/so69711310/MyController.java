package com.example.so69711310;

import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public Map<String, ? extends Object> index(@RequestParam("id") final long id) {
        final Optional<Event> res = eventRepository.findById(id);

        res.ifPresent(e -> {
            System.out.println(e.getCourse().getCourseName());
        });

        return res.map(e -> Map.of("id", e.getId(), "course", e.getCourse().getCourseName()))
            .orElse(Map.of());
    }
}
