package com.example.so59607;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
public class MyData {

    @Id
    private long id;

    private String name;
}
