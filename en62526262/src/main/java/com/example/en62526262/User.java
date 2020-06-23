package com.example.en62526262;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    private Long id;
}
