package com.example.jaso94913.repository;

import com.example.jaso94913.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book, Integer> {

}