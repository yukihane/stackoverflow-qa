package com.example.so67308;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class MyEntity {

    public MyEntity(final long id, final String name) {
        this.id = Long.valueOf(id);
        this.name = name;
    }

    @Id
    private Long id;

    @Version
    private int version;

    @Column
    private String name;
}
