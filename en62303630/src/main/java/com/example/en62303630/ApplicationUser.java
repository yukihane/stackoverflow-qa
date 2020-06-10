package com.example.en62303630;

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
public class ApplicationUser {

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Version
    private int version;

    @Column(unique = true)
    private String username;

    @Column
    private String password;
}
