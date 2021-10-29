package com.example.so69762445;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MyController {

    private final ARepository repo;

    @GetMapping
    public List<A> index() {
        final List<A> res = repo.getAll();

        //        for (final A a : res) {
        //            System.out.println("A: " + a.getName());
        //            for (final B b : a.getBs()) {
        //                System.out.println("B: " + b.getName());
        //            }
        //        }

        return res;
    }
}
