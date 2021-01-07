package com.example.so65612634.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class EntityUser {

    public EntityUser(String string, String string2) {
    }

    @Id
    @GeneratedValue
    private Long id;
}
