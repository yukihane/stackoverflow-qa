package com.github.yukihane.springsecurityauthexample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    @Column(unique = true)
    private String name;

    @Column
    private String password;

    public User(final String name, final String password) {
        this.name = name;
        this.password = password;
    }
}
