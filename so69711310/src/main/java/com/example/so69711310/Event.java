package com.example.so69711310;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Event {

    @Id
    @Column(name = "eventid")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
