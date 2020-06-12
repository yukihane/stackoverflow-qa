package com.example.en62333696;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Citizen {

    @Id
    private Long id;
    
    @Column
    private String name;
}
