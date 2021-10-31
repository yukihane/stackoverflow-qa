package com.example.so69790410;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TblDepartments {
    @Id
    private Integer dbID;
    private String dep_name;
}