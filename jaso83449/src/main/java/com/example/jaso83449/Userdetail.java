package com.example.jaso83449;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="userdetail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Userdetail implements Serializable{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private int no;
  private String id;
  private String birth;
  private String club;
  @ManyToOne
  @JoinColumn(name = "ID",insertable = false, updatable = false)
  private User user;
}
