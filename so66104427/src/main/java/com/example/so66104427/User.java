package com.example.so66104427;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    private Long id;

    private String username;

    @OneToMany
    @JoinColumn
    private Set<Blog> blogs;
}
