package com.example.so69854209;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Writer {

    @Id
    private Long id;

    private String name;
}
