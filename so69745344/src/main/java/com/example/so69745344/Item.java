package com.example.so69745344;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int volume;

    @ManyToOne
    private Category category;

    public Item(String name, int volume, Category category) {
        this.name = name;
        this.volume = volume;
        this.category = category;
    }

}
