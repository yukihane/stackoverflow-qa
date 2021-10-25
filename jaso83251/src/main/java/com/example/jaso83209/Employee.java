package com.example.jaso83209;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Table(name="employee_tbl")
@Getter
public class Employee {
  @Id
  @Column(name="empno")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long empno;

  @Column(name="empname")
  private String empname;
}
