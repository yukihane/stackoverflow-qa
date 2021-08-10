package com.example.jaso72892;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@IdClass(FullName.class)
@Setter
@Getter
@NoArgsConstructor
public class Person {

    @Id
    private String sei;
    @Id
    private String mei;

    private LocalDate birthday;
}
