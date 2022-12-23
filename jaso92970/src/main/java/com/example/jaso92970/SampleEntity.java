package com.example.jaso92970;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class SampleEntity {
    @Id
    @GeneratedValue
    private Long id;
}
