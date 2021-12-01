package com.example.so70184882;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class MyEntity {

    @Id
    private Integer id;

    private String name;
}
