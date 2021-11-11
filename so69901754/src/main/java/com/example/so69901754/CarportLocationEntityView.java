package com.example.so69901754;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class CarportLocationEntityView {

    @Id
    private Long id;

    private String externalId;

    private String carportName;
}
