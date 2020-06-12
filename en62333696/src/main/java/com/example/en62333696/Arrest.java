package com.example.en62333696;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Arrest {

    @Id
    private Long id;

    @Column
    private int duration;

}
