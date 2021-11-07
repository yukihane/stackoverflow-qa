package com.example.so69854209;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Article {

    @Id
    private Long id;

    @ManyToOne
    private Writer writer;

    private String title;
}