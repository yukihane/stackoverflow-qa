package com.example.so56679;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Prefecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
