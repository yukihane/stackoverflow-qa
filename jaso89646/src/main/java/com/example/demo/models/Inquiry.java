package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Inquiry {
    @Id
    private Long id;

}
