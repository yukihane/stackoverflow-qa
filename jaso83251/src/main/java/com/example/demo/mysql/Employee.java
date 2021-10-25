package com.example.demo.mysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class Employee {
  @Id
  @Column(name="ID")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private String ID;
  @Column(name="PASS")
  private String PASS;
  @Column(name="NAME")
  private String NAME;
  @Column(name="KANA")
  private String KANA;
}
