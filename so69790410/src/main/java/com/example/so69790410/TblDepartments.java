package com.example.so69790410;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class TblDepartments {
    @Id
    private Integer dbID;
    private String dep_name;
}