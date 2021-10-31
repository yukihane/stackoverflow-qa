package com.example.so69790410;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TblEmployees {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int emp_id;
private String empName;
private Boolean empActive;
private Integer dbID;

