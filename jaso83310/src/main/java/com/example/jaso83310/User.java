package com.example.jaso83310;

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
public class User{
  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private String id;
  @Column(name = "pass")
  private String pass;
  @Column(name = "name")
  private String name;
  @Column(name = "kana")
  private String kana;
}
