package com.example.so22663502;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import lombok.Getter;

@SqlResultSetMapping(
    name = "SomeMapping",
    classes = {
        @ConstructorResult(targetClass = SomeClass.class,
            columns = {
                @ColumnResult(name = "id", type = Integer.class),
                @ColumnResult(name = "NAME", type = String.class),
                @ColumnResult(name = "DATE_BEGIN", type = java.util.Date.class)
            })
    })
@Entity
@Table(name = "sometable")
@Getter
public class SomeEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "begdate")
    private Date begDate;

    @Column(name = "enddate")
    private Date endDate;
}
