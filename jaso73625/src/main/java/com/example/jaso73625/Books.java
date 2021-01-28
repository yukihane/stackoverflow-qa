package com.example.jaso73625;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Books implements Serializable {

    @Id
    private int id;

    @ManyToOne
    private BookCategory bookCategory;

    private String name;

    // ...略
}
