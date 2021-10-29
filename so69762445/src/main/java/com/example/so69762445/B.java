package com.example.so69762445;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class B {

    @Id
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "a")
    @JsonBackReference
    private A a;
}
