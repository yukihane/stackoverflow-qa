package com.example.en62093967;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Data;

@Entity
@Data
public class MyEntity {
    @Id
    private long id;

    @Version
    private int version;

    private String message;
}
