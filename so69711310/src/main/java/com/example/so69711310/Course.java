package com.example.so69711310;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Course {

    @Id
    @Column(name = "courseid")
    private Long id;

    @Column(name = "coursename")
    private String courseName;

    @OneToMany(mappedBy = "course")
    private List<Event> events;
}
