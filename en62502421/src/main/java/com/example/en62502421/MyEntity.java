package com.example.en62502421;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class MyEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
