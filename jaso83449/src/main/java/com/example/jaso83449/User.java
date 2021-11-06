package com.example.jaso83449;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

  @Id
  @Column(name="id")

  //@GeneratedValue(strategy=GenerationType.IDENTITY)
  private String id;

  @Column(name = "pass")
  private String pass;
  @Column(name = "name")
  private String name;
  @Column(name = "kana")
  private String kana;

  @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
  private List<Userdetail> userdetail;

}
