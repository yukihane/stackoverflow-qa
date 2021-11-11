package com.example.so69901754;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class So69901754Application {

	public static void main(final String[] args) {
		SpringApplication.run(So69901754Application.class, args);
	}

    private final CarportLocationEntityViewRepository repository;

    @GetMapping
    public List<CarportLocationEntityView> index() {
        final List<CarportLocationEntityView> ret = repository.filterCarportList("xYZ");
        return ret;
    }
}
