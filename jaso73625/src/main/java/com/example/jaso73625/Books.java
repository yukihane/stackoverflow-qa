package com.example.jaso73625;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "book")
@Data
public class Books implements Serializable {

    @Id
    private int id;

    @Column(name = "book_category_id")
    private int bookCategoryId;

    private String name;

    // ...略
}
