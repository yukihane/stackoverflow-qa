package com.example.jaso88655;

import com.example.demo.ScanBaseMarker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = ScanBaseMarker.class)
public class Jaso88655Application {

    public static void main(String[] args) {
        SpringApplication.run(Jaso88655Application.class, args);
    }

}
