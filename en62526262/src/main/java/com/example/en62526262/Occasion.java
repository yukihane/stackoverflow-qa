package com.example.en62526262;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Occasion {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
