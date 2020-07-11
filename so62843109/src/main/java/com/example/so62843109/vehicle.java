package com.example.so62843109;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class vehicle {

    @Id
    @GeneratedValue
    private Long id;

    private int year;
}
