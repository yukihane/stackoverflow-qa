package com.example.en62400654;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String location;
//    private Date birthDate;
}
