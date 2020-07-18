package com.example.so62972132.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {

    @Id
    @GeneratedValue
    int id;
    String name;
    String gender;
    String emailId;

    @OneToMany(targetEntity = ProductDetail.class,cascade = CascadeType.ALL)
    @JoinColumn(name="up_fk",referencedColumnName = "id")
    private List<ProductDetail> userpurchase;

}
