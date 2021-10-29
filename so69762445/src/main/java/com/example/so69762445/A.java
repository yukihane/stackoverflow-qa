package com.example.so69762445;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;

@Entity
@Getter
public class A {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "a")
    @JsonManagedReference
    private List<B> bs;
}
