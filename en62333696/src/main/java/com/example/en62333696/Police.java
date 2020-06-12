package com.example.en62333696;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Police {

    @Id
    private Long id;
}
