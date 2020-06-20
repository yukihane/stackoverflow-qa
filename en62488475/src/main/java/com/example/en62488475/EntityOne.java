package com.example.en62488475;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class EntityOne implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "entity_one_id", updatable = false, nullable = false)
    private Long id;

}