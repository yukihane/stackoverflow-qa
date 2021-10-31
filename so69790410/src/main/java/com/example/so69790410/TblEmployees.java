package com.example.so69790410;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class TblEmployees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;
    private String empName;
    private Boolean empActive;
    @ManyToOne
    @JoinColumn(name = "dbid")
    private TblDepartments department;

}
