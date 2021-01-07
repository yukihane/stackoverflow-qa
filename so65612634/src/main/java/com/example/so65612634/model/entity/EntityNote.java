package com.example.so65612634.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EntityNote {

    @Id
    @GeneratedValue
    private Long id;
}
