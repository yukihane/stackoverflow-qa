package com.example.so67679;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Comment {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Integer id;
private String text;
private LocalDateTime postDateTime;

@ManyToOne         //多対１の関係。Commentは一つブログに結びついている。
private Blog blog;

}
