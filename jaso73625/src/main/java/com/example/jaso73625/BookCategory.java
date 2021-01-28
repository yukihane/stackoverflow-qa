package com.example.jaso73625;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book_category")
@Data
public class BookCategory implements Serializable {

    @Id
    private int id;

    private String category;

    // ...略
}
