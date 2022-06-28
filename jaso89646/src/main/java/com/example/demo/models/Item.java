package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item implements Serializable {
    private static final long serialVersionUID = -6647247658748349084L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 30)
    private String name;

    @NotBlank
    private int price;

    @NotBlank
    @Size(max = 400)
    private String detail;
    
    public void clear() {
        name = null;
        price = 0;
        detail = null;
    }
}
