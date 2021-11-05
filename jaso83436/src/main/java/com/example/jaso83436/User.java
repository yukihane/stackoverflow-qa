package com.example.jaso83436;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class User {

    @Id
    private String id;
    
    private String name;
}
